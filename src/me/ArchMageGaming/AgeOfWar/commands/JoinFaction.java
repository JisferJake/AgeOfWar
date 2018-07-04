package me.ArchMageGaming.AgeOfWar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ArchMageGaming.AgeOfWar.Main;

public class JoinFaction implements CommandExecutor {
	
	private Main plugin;
	
	public JoinFaction(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("This Command can only be run by a player!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("joinfaction.use")) {
			p.sendMessage("You have joined " + plugin.getConfig().getString("faction_one"));
			return true;
		} else {
			p.sendMessage("You don't have permission to run this command!");
		}
		
		return false;
	}
	
}
