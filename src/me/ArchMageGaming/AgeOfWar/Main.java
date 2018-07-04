package me.ArchMageGaming.AgeOfWar;

import org.bukkit.plugin.java.JavaPlugin;

import me.ArchMageGaming.AgeOfWar.commands.JoinFaction;
import me.ArchMageGaming.AgeOfWar.join.JoinListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new JoinListener(this);
		new JoinFaction(this);
	}

}
