package me.ArchMageGaming.AgeOfWar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ArchMageGaming.AgeOfWar.Main;

public class Hello implements CommandExecutor {
	
	private Main plugin;
	
	public Hello(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can execute this command!");
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("hello.use")) {
			p.sendMessage("hi!");
			return true;
		} else {
			p.sendMessage("You do not have permission to run this command!");
		}
		return false;
	}

}
