package me.ArchMageGaming.AgeOfWar.join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.ArchMageGaming.AgeOfWar.Main;
import me.ArchMageGaming.AgeOfWar.Utils.Utils;

//implements the listener stuff cause its needed
public class JoinListener  implements Listener {

	private Main plugin;

	//constructor for calling in the main class
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	//when player joins, do this
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		//get player who joins
		Player p = e.getPlayer();

		//checks if player has played before
		if(!p.hasPlayedBefore()) {
			//sends message
			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("<player>", p.getName())));
		} else {
			//sends message
			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", p.getDisplayName())));
		}
	}

}

