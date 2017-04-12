package fr.tournoi.survivalgames.listeners;

import java.util.HashMap;

import fr.tournoi.survivalgames.api.inventory.kit.Kit;

public class Management {

	// Pseudo du joueur<String> & <Integer> la valeur du kit
	public static HashMap<String, Kit> players = new HashMap<>();

	// prefix
	public static String prefix = "§f[§6SurvivalGames§f]";

}
