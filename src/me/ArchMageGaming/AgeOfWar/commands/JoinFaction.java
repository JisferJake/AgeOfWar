package me.ArchMageGaming.AgeOfWar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ArchMageGaming.AgeOfWar.Main;
import me.ArchMageGaming.AgeOfWar.Utils.Utils;

public class JoinFaction implements CommandExecutor {

	private Main plugin;

	//Constructor for initializing the command
	public JoinFaction(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("join").setExecutor(this);
	}
	
	//when command is typed, this is what runs
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//adds player object
		Player p = (Player) sender;

		//checks for permission
		if(p.hasPermission("joinfaction.use")) {
		
			//checks if there is a second part of the command (/join <faction>)
			if (args.length == 0) {
				//sends proper syntax message
				p.sendMessage(Utils.chat("&4Proper Syntax: /join <faction>"));
				return true;
			} else {
				//checks if the faction is Yulania
				if(args[0].equalsIgnoreCase("Yulania")){
					//player joins Yulania
					p.sendMessage(Utils.chat("&6You have joined Yulania!"));
				} else {
					//tells the player the faction they put does not exist
					p.sendMessage(Utils.chat("&cThat is not an existing faction!"));
				}
			}
			
		}
			

		
		return false;
	}
	
}
