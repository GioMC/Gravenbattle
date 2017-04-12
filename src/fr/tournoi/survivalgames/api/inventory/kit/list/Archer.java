package fr.tournoi.survivalgames.api.inventory.kit.list;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.tournoi.survivalgames.api.inventory.Helper;
import fr.tournoi.survivalgames.api.inventory.kit.Kit;
import fr.tournoi.survivalgames.listeners.Management;

public class Archer extends Kit {

	@Override
	public String getName() {
		return "kit Archer";
	}

	@Override
	public void setItemDefault(Player player) {
		player.getInventory().clear();
		player.getInventory().setItem(0, Helper.createItem(Material.IRON_SWORD, "Ep�e du kit Archer"));
		player.getInventory().setItem(1, Helper.createItem(Material.APPLE, "Pain du kit Archer"));
		player.sendMessage(Management.prefix + "Vous avez re�u le kit Archer");
		player.updateInventory();

	}

}
