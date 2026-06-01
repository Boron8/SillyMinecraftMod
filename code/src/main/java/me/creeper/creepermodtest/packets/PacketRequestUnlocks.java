package me.creeper.creepermodtest.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import me.creeper.creepermodtest.magic.MagicData;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.Set;

public class PacketRequestUnlocks implements IMessage {
    public PacketRequestUnlocks() {}

    @Override public void toBytes(ByteBuf buf) {}
    @Override public void fromBytes(ByteBuf buf) {}

    public static class Handler implements IMessageHandler<PacketRequestUnlocks, IMessage> {
        @Override
        public IMessage onMessage(PacketRequestUnlocks message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().playerEntity;

            Set<String> unlocks = MagicData.getUnlocks(player);

            PacketHandler.INSTANCE.sendTo(new PacketSyncUnlocks(unlocks), player);

            return null;
        }
    }
}
