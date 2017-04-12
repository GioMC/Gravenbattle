package fr.tournoi.survivalgames.api.inventory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Helper {

	public static ItemStack createItem(Material material, int number, byte damageValue, String displayName,
			List<String> list) {

		ItemStack item = new ItemStack(material, number, damageValue);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		itemM.setLore(list);
		item.setItemMeta(itemM);

		return item;

	}

	public static ItemStack createItem(Material material, byte damageValue, String displayName, List<String> list) {

		ItemStack item = new ItemStack(material, 1, damageValue);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		itemM.setLore(list);
		item.setItemMeta(itemM);

		return item;

	}

	public static ItemStack createItem(Material material, int number, String displayName, List<String> list) {

		ItemStack item = new ItemStack(material, number, (byte) 0);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		itemM.setLore(list);
		item.setItemMeta(itemM);

		return item;

	}

	public static ItemStack createItem(Material material, String displayName, List<String> list) {

		ItemStack item = new ItemStack(material, 1, (byte) 0);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		itemM.setLore(list);
		item.setItemMeta(itemM);

		return item;

	}

	public static ItemStack createItem(Material material) {
		return new ItemStack(material, 1, (byte) 0);

	}

	public static ItemStack createItem(Material material, String displayName, boolean glow, List<String> list) {

		ItemStack item = new ItemStack(material, 1, (byte) 0);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		itemM.setLore(list);
		itemM.addEnchant(Enchantment.DURABILITY, 0, true);
		itemM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemM);

		return item;

	}

	public static ItemStack createItemSkull(String playerName, String displayName, List<String> list)
			throws MalformedURLException, IOException {

		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		meta.setOwner(playerName);
		meta.setDisplayName(displayName);
		meta.setOwner(Bukkit.getOfflinePlayer(UUID.fromString("9b8d31d5-420c-4f0c-80f0-de834b737a99")).getName());
		meta.setLore(list);
		skull.setItemMeta(meta);
		try {
			System.out.println(test());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return skull;

	}

	private static ArrayList<String> test() throws Exception {
		ArrayList<String> chaine = new ArrayList<>();
		HttpURLConnection conn1 = (HttpURLConnection) new URL(
				"https://sessionserver.mojang.com/session/minecraft/profile/9b8d31d5420c4f0c80f0de834b737a99")
						.openConnection();
		conn1.connect();

		BufferedInputStream bis = new BufferedInputStream(conn1.getInputStream());

		byte[] bytes = new byte[1024];
		int tmp;
		while ((tmp = bis.read(bytes)) != -1) {
			chaine.add(new String(bytes, 0, tmp) + "\n\n");
		}
		return chaine;
	}

	public static ItemStack createItem(Material material, String displayName) {
		ItemStack item = new ItemStack(material);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		item.setItemMeta(itemM);
		return item;
	}
	
	public static ItemStack createItem(Material material, int number, String displayName) {
		ItemStack item = new ItemStack(material, number);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(displayName);
		item.setItemMeta(itemM);
		return item;
	}

}
