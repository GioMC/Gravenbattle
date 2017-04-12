package fr.tournoi.survivalgames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import java.util.Random; 

public class RandomChest {
	
	
	// Les items des coffres
	static ItemStack goldenapple = new ItemStack(Material.GOLDEN_APPLE, 2);
	static ItemStack bread = new ItemStack(Material.BREAD, 12);
	static ItemStack arrows = new ItemStack(Material.ARROW, 64);
	static ItemStack  eggs = new ItemStack(Material.EGG, 16);
	static ItemStack  woods = new ItemStack(Material.WOOD, 64);
	static ItemStack  stones = new ItemStack(Material.STONE, 64);
	
	
	
    public static void regenChest(){
        Chunk[] arrayChunks;
        int j = (arrayChunks = ((World) Bukkit.getWorlds().get(0)).getLoadedChunks()).length;
        for(int i = 0; i < j; i++){
            Chunk chunk = arrayChunks[i];
            BlockState[] arrayOfBlockStates;
            int m = (arrayOfBlockStates = chunk.getTileEntities()).length;
            for(int k = 0; k < m; k++){
                BlockState chests = arrayOfBlockStates[k];
                if((chests instanceof Chest)){
                    Chest chest = (Chest)chests;

                    Random random = new Random();
                    int slot1 = random.nextInt(26);
                    int slot2 = random.nextInt(26);
                    int slot3 = random.nextInt(26);
                    int slot4 = random.nextInt(26);
                    int slot5 = random.nextInt(26);
                    int slot6 = random.nextInt(26);

                    Material[] sword = {
                            Material.STONE_SWORD, Material.IRON_SWORD,
                            Material.FISHING_ROD, Material.BOW };

                    Material[] stuff = {
                            Material.LEATHER_HELMET, Material.IRON_HELMET,
                            Material.LEATHER_CHESTPLATE, Material.IRON_CHESTPLATE,
                            Material.LEATHER_LEGGINGS, Material.IRON_LEGGINGS,
                            Material.LEATHER_BOOTS, Material.IRON_BOOTS };

                    Material[] materials = {
                      Material.DIAMOND_AXE, Material.IRON_AXE, Material.DIAMOND_PICKAXE, Material.IRON_PICKAXE
                    };

                    ItemStack[] eat = {
                            bread, goldenapple };

                    ItemStack[] other = {
                            arrows, eggs };

                    ItemStack[] blocks = {
                            woods };

                    chest.getInventory().clear();
                    chest.getInventory().setItem(slot1, new ItemStack(sword[random.nextInt(sword.length)]));
                    chest.getInventory().setItem(slot2, new ItemStack(stuff[random.nextInt(stuff.length)]));
                    chest.getInventory().setItem(slot3, new ItemStack(eat[random.nextInt(eat.length)]));
                    chest.getInventory().setItem(slot4, new ItemStack(other[random.nextInt(other.length)]));
                    chest.getInventory().setItem(slot5, new ItemStack(blocks[random.nextInt(blocks.length)]));
                    chest.getInventory().setItem(slot6, new ItemStack(materials[random.nextInt(blocks.length)]));
                }
            }
        }
    }

}
