package fr.tournoi.survivalgames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.tournoi.survivalgames.Waiting;
import fr.tournoi.survivalgames.api.inventory.Helper;

public class JoinGame implements Listener {
	
	private final Waiting wait;

	public JoinGame(Waiting wait) {
		this.wait = wait;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();
		Bukkit.broadcastMessage(Management.prefix + "[+] " + player.getName());
		wait.addPlayer();
		player.getInventory().setItem(0, Helper.createItem(Material.COMPASS, "Choix des kits"));
		if(wait.getPlayersNumber()>=1){
			wait.launchWait(11);
		}
	}

}
