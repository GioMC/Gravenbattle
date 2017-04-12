package fr.tournoi.survivalgames.api.inventory.kit;

import org.bukkit.entity.Player;

public abstract class Kit {

	public abstract String getName();

	public abstract void setItemDefault(Player player);

}
