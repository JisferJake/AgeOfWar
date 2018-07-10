package me.ArchMageGaming.AgeOfWar.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

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
		
		//sets locations of factions
		Location faction_two = new Location(Bukkit.getWorld("Medieval Warmap Finished"), 547, 72, 654);

		//checks for permission
		if(p.hasPermission("joinfaction.use")) {
		
			//checks if there is a second part of the command (/join <faction>)
			if (args.length == 0) {
				//sends proper syntax message
				p.sendMessage(Utils.chat("&4Proper Syntax: /join <faction>"));
				return true;
			} else if(args.length == 1){
				
									
					//checks for which faction
					if(args[0].equalsIgnoreCase(plugin.getConfig().getString("faction_one"))) {
						
						Bukkit.broadcastMessage(p.getDisplayName() + " has joined " + plugin.getConfig().getString("faction_one"));
						return true;
						
					}else if(args[0].equalsIgnoreCase(plugin.getConfig().getString("faction_two"))){
						
						Bukkit.broadcastMessage(p.getDisplayName() + " has joined " + plugin.getConfig().getString("faction_two"));
						p.teleport(faction_two);
						return true;
						
					}else if(args[0].equalsIgnoreCase(plugin.getConfig().getString("faction_three"))){
						
						Bukkit.broadcastMessage(p.getDisplayName() + " has joined " + plugin.getConfig().getString("faction_three"));
						return true;
						
					}else if(args[0].equalsIgnoreCase(plugin.getConfig().getString("faction_four"))) {
						
						Bukkit.broadcastMessage(p.getDisplayName() + " has joined " + plugin.getConfig().getString("faction_four"));
						return true;
						
					} else {
						p.sendMessage(Utils.chat("&cThis is not an existing faction!"));
						return true;
					}	
					
				
					
				
			} else if(args.length > 1) {
				p.sendMessage(Utils.chat("&4Proper Syntax: /join <faction>"));
				return true;
			}
			
		} else {
			p.sendMessage(Utils.chat("&4You do not have permission to execute this command!"));
		}
			

		
		return false;
	}
	
}
