package me.creeper.creepermodtest.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import me.creeper.creepermodtest.magic.MagicCache;

public class PacketUnlockUpdate implements IMessage {

    private String key;

    public PacketUnlockUpdate() {}

    public PacketUnlockUpdate(String key) {
        this.key = key;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        key = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, key);
    }

    public static class Handler implements IMessageHandler<PacketUnlockUpdate, IMessage> {
        @Override
        public IMessage onMessage(PacketUnlockUpdate message, MessageContext ctx) {
            MagicCache.add(message.key);

            return null;
        }
    }
}
