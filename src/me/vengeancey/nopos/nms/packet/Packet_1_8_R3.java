package me.vengeancey.nopos.nms.packet;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.vengeancey.nopos.nms.IPacket;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityStatus;

public class Packet_1_8_R3 implements IPacket
{

	@Override
	public void disableCoordinates(final Player player) 
	{
		PacketPlayOutEntityStatus packet = new PacketPlayOutEntityStatus(((CraftPlayer) player).getHandle(), (byte) 22);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
}