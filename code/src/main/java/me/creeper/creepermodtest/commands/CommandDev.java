package me.creeper.creepermodtest.commands;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CommandDev extends CommandBase  {
    @Override
    public String getCommandName() { return "dev"; }

    @Override
    public String getCommandUsage(ICommandSender sender) { return "command.dev.usage"; }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length <= 0) return;
        String arg = args[0];
        if (Objects.equals(arg, "remove_recipe")) {
            List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

            Iterator<IRecipe> iterator = recipes.iterator();

            while (iterator.hasNext()) {
                IRecipe recipe = iterator.next();

                if (recipe.getRecipeOutput() != null && recipe.getRecipeOutput().getItem() == Items.bread) {
                    String id = Item.itemRegistry.getNameForObject(recipe.getRecipeOutput().getItem());

                    sender.addChatMessage(new ChatComponentText("Removed recipe for '" + id + "'"));

                    iterator.remove();

                    return; // early stop, for only 1 item
                }
            }
        } else if (Objects.equals(arg, "forge_init")) {
            MinecraftForge.initialize();
        } else if (Objects.equals(arg, "reg_item")) {
            Item i = new DevItem();
            GameRegistry.registerItem(i, i.getUnlocalizedName().substring(5));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return ExampleMod.getMainConfig().dev_command; }


    public static class DevItem extends Item {
        public DevItem() {
            this.setCreativeTab(ExampleMod.tabCreepermodtest);
            this.setMaxStackSize(64);

            this.setUnlocalizedName("itemDevItem");
            this.setTextureName("minecraft:stone");
        }
    }
}
