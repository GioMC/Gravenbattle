package fr.tournoi.survivalgames.api.inventory.kit.list;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.tournoi.survivalgames.api.inventory.Helper;
import fr.tournoi.survivalgames.api.inventory.kit.Kit;
import fr.tournoi.survivalgames.listeners.Management;

public class Guerrier extends Kit {

	public String getName() {
		return "kit Guerrier";
	}

	public void setItemDefault(Player player) {
		player.getInventory().clear();
		player.getInventory().setItem(0, Helper.createItem(Material.IRON_SWORD, "Epée du kit Guerrier"));
		player.getInventory().setItem(1, Helper.createItem(Material.COOKED_BEEF, "Steak du kit Guerrier"));
		player.sendMessage(Management.prefix + "Vous avez reçu le kit Guerrier");
		player.updateInventory();

	}

}
