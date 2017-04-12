package fr.tournoi.survivalgames;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.tournoi.survivalgames.api.inventory.MenuSystem;
import fr.tournoi.survivalgames.api.inventory.list.WaitMenu;

public class InteractEvent implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent event) {

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item != null && item.getType() == Material.COMPASS)
                MenuSystem.open(event.getPlayer(), WaitMenu.class);
        }

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getInventory();
        ItemStack current = event.getCurrentItem();

        if (event.getCurrentItem() == null)
            return;

        MenuSystem.getRegisteredMenus().values().stream().filter(menu -> inv.getName().equalsIgnoreCase(menu.name()))
                .forEach(menu -> {
                    player.closeInventory();
                    menu.onClick(player, inv, current, event.getSlot());
                    event.setCancelled(true);
                });

    }

}