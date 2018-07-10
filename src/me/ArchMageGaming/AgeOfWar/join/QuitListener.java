package me.ArchMageGaming.AgeOfWar.join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.ArchMageGaming.AgeOfWar.Main;
import me.ArchMageGaming.AgeOfWar.Utils.Utils;

public class QuitListener implements Listener {
	
	private Main plugin;
	
	public QuitListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent q) {
		Player p = q.getPlayer();
		
		Bukkit.broadcastMessage(
				Utils.chat(plugin.getConfig().getString("leave_message").replace("<player>", p.getDisplayName())));
	}

}
