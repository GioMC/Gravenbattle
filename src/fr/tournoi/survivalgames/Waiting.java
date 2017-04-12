package fr.tournoi.survivalgames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.tournoi.survivalgames.api.inventory.kit.Kit;
import fr.tournoi.survivalgames.listeners.Management;
import fr.tournoi.survivalgames.listeners.RandomChest;
import fr.tournoi.survivalgames.listeners.SpawnChest;
import fr.tournoi.survivalgames.listeners.TeleportPlayers;


public class Waiting {

	private final SurvivalGames plugin;
	private int players;
	private int delay;

	public Waiting(SurvivalGames plugin) {
		this.plugin = plugin;
	}

	public void addPlayer() {
		players++;
		launchWait(60);
	}

	public void removePlayer() {
		players--;
	}

	public int getPlayersNumber() {
		return this.players;
	}
	
	

	public void launchWait(int time) {

		delay = time;

		new BukkitRunnable() {

			@Override
			public void run() {
				delay--;
				if (delay == 30 || delay == 15 || delay == 10 || delay >= 5)
					Bukkit.broadcastMessage("Le SurvivalGames va commencer dans " + delay + " secondes !");

				if (delay <= 0) {
					Bukkit.broadcastMessage("Le SurvivalGames commence ! Bonne chance !");
					
					
					// téléportation des joueurs et inizialisations de stuffs
					giveDefaultItem();
					
					// generation des coffres sur la map
					SpawnChest.ChestSpawn();
					
					// teleportation des joueurs
					for(Player p : Bukkit.getOnlinePlayers()){
						TeleportPlayers.tpPlayers(p);
					}	
					// remplismeent des coffres
					RandomChest.regenChest();
					cancel();
				}

			}

		}.runTaskTimer(plugin, 20L, 20L);

	}

	private static void giveDefaultItem() {
		  for (String playerNames : Management.players.keySet()) {
	            Kit kit = Management.players.get(playerNames);
	            kit.setItemDefault(Bukkit.getPlayer(playerNames));
	            Bukkit.getPlayer(playerNames).sendMessage(Management.prefix + "Vous avez le " + kit.toString() + " ! ");
	        }
	
	}

}
