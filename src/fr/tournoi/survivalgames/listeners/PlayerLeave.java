package fr.tournoi.survivalgames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener{
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		String name = p.getName();
		if(Management.players.containsKey(name)){
			// on enleve le joueur suite a sa deconexion
			Management.players.remove(name);
			// ainsi on en informe les autres joueur qu'il a quitte la partie
			Bukkit.broadcastMessage(Management.prefix+ " §fAie.. Le joueur "+name+ " à quitté la partie ! :'(");
		}
	}

}
