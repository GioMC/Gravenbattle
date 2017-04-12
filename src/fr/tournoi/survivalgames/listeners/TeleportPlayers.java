package fr.tournoi.survivalgames.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TeleportPlayers{ 
	
	public static void tpPlayers(Player p){
		Random r = new Random();
	//5 blocks de distances entre chaque joueurs
		int x = 5 + r.nextInt(5);
		int y = 64;// hauteur par defaut dans minecraft
		int z = 5 + r.nextInt(5);
		
		Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
		Material m = loc.getBlock().getType();
		if(m==null || m == Material.AIR){
			tpPlayers(p);
			p.sendMessage("Téléportation");
			return;
		}
		p.teleport(loc);
	}
	
	

}
