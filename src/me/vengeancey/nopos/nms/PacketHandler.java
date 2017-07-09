package me.vengeancey.nopos.nms;

import org.bukkit.Bukkit;

import me.vengeancey.nopos.nms.packet.Packet_1_8_R1;
import me.vengeancey.nopos.nms.packet.Packet_1_8_R2;
import me.vengeancey.nopos.nms.packet.Packet_1_8_R3;

public class PacketHandler
{
	
	/* Our shared packethandler instance */
	
	private static final PacketHandler packetHandler = new PacketHandler();
	
	/* Our interface object */
	
	private IPacket packet;
	
	public static PacketHandler getInstance()
	{
		return packetHandler;
	}
	
	public IPacket getPacket()
	{
		return this.packet;
	}
	
	/* Prevent initialization */
	private PacketHandler() {
	}
	
	/* Method to check server version */
	
	private String getVersion() {
		String version = null;
		try
		{
			version = Bukkit.getServer().getClass().getName().split("\\.")[3];
		} catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		return version;
	}
	
	/* To be called upon enabling the server */
	
	public boolean setupPacket()
	{
		switch (getVersion())
		{
			case "v1_8_R1":
				this.packet = new Packet_1_8_R1();
				break;
			case "v1_8_R2":
				this.packet = new Packet_1_8_R2();
				break;
			case "v1_8_R3":
				this.packet = new Packet_1_8_R3();
				break;
		}
		return this.packet != null;
	}
}