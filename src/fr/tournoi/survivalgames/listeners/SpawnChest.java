package fr.tournoi.survivalgames.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class SpawnChest {
	
	static int i = 0;
	
	public static void ChestSpawn(){
		if(i>=35){return;}
		Random r = new Random();
		// les coffres se générents assez facilement
		int x = 5 + r.nextInt(35);
		int y = 64;// hauteur par defaut dans minecraft
		int z = 5 + r.nextInt(35);
		Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
		loc.getBlock().setType(Material.CHEST);
		i++;
		Bukkit.broadcastMessage(""+i);
		ChestSpawn();
	}

}
