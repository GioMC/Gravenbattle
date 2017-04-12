package fr.tournoi.survivalgames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathPlayers implements Listener{
	
	
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player  p = e.getEntity();
		String name = p.getName();
		if(p instanceof Player){
			if(Management.players.containsKey(name)){
				Bukkit.broadcastMessage(Management.prefix+ "§6Le joueur §c"+name+" §6est mort !");
				// on enleve le joueur mort de la hashmap
				Management.players.remove(name);
				//set des paramertre de reaparitions
			}
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		p.setGameMode(GameMode.SPECTATOR);
		Location spawnloc = new Location(Bukkit.getWorld("world"), 0, 0, 0);
		p.teleport(spawnloc);
		p.sendMessage(Management.prefix+" §fRetournez au lobby avec la commande /lobby !");
	}

}
