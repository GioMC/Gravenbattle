package fr.tournoi.survivalgames;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChangeBlock implements Listener {

    private final ArrayList<Chunk> chunkalreadyLoaded = new ArrayList<>();

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.MONITOR)
    public void loadChunk(ChunkLoadEvent event) {

        Chunk chunk = event.getChunk();
        if (chunkalreadyLoaded.contains(chunk))
            return;

        chunkalreadyLoaded.add(chunk);

        for (int x = 1; x < 15; x++) {

            for (int z = 1; z < 15; z++) {

                for (int y = 1; y < 100; y++) {

                    Block block = chunk.getBlock(x, y, z);

                    if (block.getType() == Material.WOOD)
                        block.setType(Material.QUARTZ_BLOCK);

                    if (block.getType() == Material.LEAVES)
                        block.setType(Material.PACKED_ICE);

                    if (block.getType() == Material.GRASS)
                        block.setType(Material.COAL_BLOCK);

                    if (block.getType() == Material.BIRCH_WOOD_STAIRS)
                        block.setType(Material.QUARTZ_BLOCK);

                    if (block.getType() == Material.BIRCH_WOOD_STAIRS)
                        block.setType(Material.QUARTZ_BLOCK);

                    if (block.getType() == Material.BIRCH_WOOD_STAIRS)
                        block.setType(Material.QUARTZ_BLOCK);

                }
            }
        }
        }
    }

