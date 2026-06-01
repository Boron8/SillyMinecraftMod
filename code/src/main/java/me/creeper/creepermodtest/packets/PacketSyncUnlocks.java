package me.creeper.creepermodtest.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import me.creeper.creepermodtest.magic.MagicCache;

import java.util.HashSet;
import java.util.Set;

public class PacketSyncUnlocks implements IMessage {

    private Set<String> unlocks;

    public PacketSyncUnlocks() {}

    public PacketSyncUnlocks(Set<String> unlocks) {
        this.unlocks = unlocks;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int count = buf.readInt();
        unlocks = new HashSet<>();
        for (int i = 0; i < count; i++) {
            unlocks.add(ByteBufUtils.readUTF8String(buf));
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(unlocks.size());
        for (String key : unlocks) {
            ByteBufUtils.writeUTF8String(buf, key);
        }
    }

    public static class Handler implements IMessageHandler<PacketSyncUnlocks, IMessage> {
        @Override
        public IMessage onMessage(PacketSyncUnlocks message, MessageContext ctx) {
            MagicCache.setAll(message.unlocks);

            return null;
        }
    }
}
