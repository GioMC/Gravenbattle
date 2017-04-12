package fr.tournoi.survivalgames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class CheckWinner {
    static int task;
	
	public static void winnerwin(){
		int i = 0; 
		for(Player players : Bukkit.getOnlinePlayers()){
			if(Management.players.containsKey(players.getName())){
				i++;
				if(i==1){
					Bukkit.broadcastMessage(Management.prefix+ " §fBravo à §b"+players.getName()+ " §f, il remporte un lot de panzani pates !");
				}
			}
		}
	}
	
	
	public void shutdownServerAndTeleportPlayersToLobby(){
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Skywars"), new Runnable() {
            @Override
            public void run() {
            	Bukkit.broadcastMessage(Management.prefix+ " §fVous allez êtres redirigés vers le lobby !");
            	ByteArrayDataOutput out = ByteStreams.newDataOutput();
            	out.writeUTF("Connect");
            	out.writeUTF("lobby");
            	for(Player players : Bukkit.getOnlinePlayers()){
            		players.sendPluginMessage(Bukkit.getPluginManager().getPlugin("SurvivalGame"), "BungeeCord", out.toByteArray());
            	}
            	Bukkit.shutdown();
                                   
            }
        }, 20L, 20L);
	}

}
