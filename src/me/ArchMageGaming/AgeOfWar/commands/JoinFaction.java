package me.ArchMageGaming.AgeOfWar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ArchMageGaming.AgeOfWar.Main;
import me.ArchMageGaming.AgeOfWar.Utils.Utils;

public class JoinFaction implements CommandExecutor {

	private Main plugin;

	public JoinFaction(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("join").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if(p.hasPermission("joinfaction.use")) {
		
			if (args.length == 0) {
				p.sendMessage(Utils.chat("&4Proper Syntax: /join <faction>"));
				return true;
			} else {
				if(args[0].equalsIgnoreCase("Yulania")){
					p.sendMessage(Utils.chat("&6You have joined Yulania!"));
				} else {
					p.sendMessage(Utils.chat("&cThat is not an existing faction!"));
				}
			}
			
		}
			

		
		return false;
	}
	
}
