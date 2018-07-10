package me.ArchMageGaming.AgeOfWar.commands;
/*
 *THIS IS THE TEMPLATE CLASS FOR A COMMAND.
 * DO NOT USE IN THE ACTUAL PLUGIN.
 */


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ArchMageGaming.AgeOfWar.Main;

//implements the command executor stuff. needed for commands
public class Hello implements CommandExecutor {
	
	private Main plugin;
	
	
	//Constructor for initializing the command (Needed for all commands)
	public Hello(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}

	//when command is typed, this is what runs
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//makes sure the sender of the command is a player, not the console.
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can execute this command!");
		}
		
		//adds the player object to be referenced
		Player p = (Player) sender;
		
		//checks if the player has permission to use the command
		if(p.hasPermission("hello.use")) {
			//sends message back 
			p.sendMessage("hi!");
			return true;
		} else {
			//tells player they need the permission
			p.sendMessage("You do not have permission to run this command!");
		}
		return false;
	}

}
