package fr.tournoi.survivalgames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.tournoi.survivalgames.Waiting;

public class QuitEvent implements Listener {

	private final Waiting wait;

	public QuitEvent(Waiting wait) {
		this.wait = wait;
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {

		Player player = event.getPlayer();
		Bukkit.broadcastMessage(Management.prefix + "[-] " + player.getName());
		wait.removePlayer();
		Management.players.remove(player);
		player.getInventory().clear();
		player.updateInventory();

	}

}
