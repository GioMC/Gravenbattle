package fr.tournoi.survivalgames.api.inventory.list;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.tournoi.survivalgames.api.inventory.CustomInventory;
import fr.tournoi.survivalgames.api.inventory.Helper;
import fr.tournoi.survivalgames.api.inventory.kit.list.Archer;
import fr.tournoi.survivalgames.api.inventory.kit.list.Bourrin;
import fr.tournoi.survivalgames.api.inventory.kit.list.Guerrier;
import fr.tournoi.survivalgames.listeners.Management;

public class WaitMenu implements CustomInventory {

	@Override
	public String name() {
		return "Choix du kit";
	}

	@Override
	public void contents(Player player, Inventory inv) {
		inv.setItem(0, Helper.createItem(Material.IRON_SWORD, "Kit Guerrrier"));
		inv.setItem(1, Helper.createItem(Material.BOW, "Kit Archer"));
		inv.setItem(3, Helper.createItem(Material.LEATHER_CHESTPLATE, "Kit bourrin"));

	}

	@Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {

        if (current.getType() == Material.IRON_SWORD) {
            Management.players.put(player.getName(), new Guerrier());
            player.sendMessage(Management.prefix + "Vous avez choisis le kit " + Guerrier.class.toString() + " !");
        } else if (current.getType() == Material.BOW) {
            Management.players.put(player.getName(), new Archer());
        } else if (current.getType() == Material.LEATHER_CHESTPLATE) {
            Management.players.put(player.getName(), new Bourrin());
        }

    }

	@Override
	public int getSize() {
		return 27;
	}

}
