package fr.tournoi.survivalgames;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tournoi.survivalgames.api.inventory.MenuSystem;
import fr.tournoi.survivalgames.api.inventory.list.WaitMenu;
import fr.tournoi.survivalgames.listeners.DeathPlayers;
import fr.tournoi.survivalgames.listeners.JoinGame;
import fr.tournoi.survivalgames.listeners.PlayerLeave;
import fr.tournoi.survivalgames.listeners.QuitEvent;

public class SurvivalGames extends JavaPlugin {

	@Override
	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();
		
		Waiting wait = new Waiting(this);
		
		pm.registerEvents(new JoinGame(wait), this);
		pm.registerEvents(new QuitEvent(wait), this);
		
		pm.registerEvents(new DeathPlayers(), this);
		pm.registerEvents(new PlayerLeave(), this);
		pm.registerEvents(new QuitEvent(wait), this);
		
		pm.registerEvents(new InteractEvent(), this);
		
		pm.registerEvents(new ChangeBlock(), this);
		
		MenuSystem.addMenu(new WaitMenu());
		// rajouter la class pour pouvoir généréer le monde
	}

}
