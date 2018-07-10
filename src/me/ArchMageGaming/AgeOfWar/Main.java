package me.ArchMageGaming.AgeOfWar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ArchMageGaming.AgeOfWar.commands.Hello;
import me.ArchMageGaming.AgeOfWar.commands.JoinFaction;
import me.ArchMageGaming.AgeOfWar.join.JoinListener;
import me.ArchMageGaming.AgeOfWar.join.QuitListener;

public class Main extends JavaPlugin {

	//when the plugin is enabled, do this
	@Override
	public void onEnable() {
		getLogger().info("The Age Of War has begun.");
		
		saveDefaultConfig();
		
		//initializes functions of plugin
		new Hello(this);
		new JoinListener(this);
		new QuitListener(this);
		new JoinFaction(this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("The Age Of War has ended.");
	}

}
