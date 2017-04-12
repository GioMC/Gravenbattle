package fr.tournoi.survivalgames.api.inventory.kit.list;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.tournoi.survivalgames.api.inventory.Helper;
import fr.tournoi.survivalgames.api.inventory.kit.Kit;
import fr.tournoi.survivalgames.listeners.Management;

public class Bourrin extends Kit {

	@Override
	public String getName() {
		return "kit bourrin";
	}

	@Override
	public void setItemDefault(Player player) {
		player.getInventory().clear();
		player.getInventory().setItem(0, Helper.createItem(Material.IRON_SWORD, "Epée du kit Guerrier"));
		player.getInventory().setItem(1, Helper.createItem(Material.BREAD, "Pomme du kit guerrier"));
		player.sendMessage(Management.prefix + "Vous avez reçu le kit Bourrin");
		player.updateInventory();

	}

}
