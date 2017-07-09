package me.vengeancey.nopos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.vengeancey.nopos.nms.PacketHandler;

/**
*
*	Author: Vengeancey
*	Date: 9th of July, 2017.
*
*/

public class Main extends JavaPlugin implements Listener
{
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		if (PacketHandler.getInstance().setupPacket())
		{
			System.out.println("Version compatible.");
		} else
		{
			System.out.println("System version incompatible. Shutting down...");
			getServer().getPluginManager().disablePlugin(this);
		}
	}
	
	@EventHandler
	public void onJoin(final PlayerJoinEvent event)
	{
		if (event.getPlayer().hasPermission("nopos.coord"))
		{
			PacketHandler.getInstance().getPacket().disableCoordinates(event.getPlayer());
		}
	}
}