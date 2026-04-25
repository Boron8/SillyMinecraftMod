package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChatComponentText;

import java.util.Iterator;
import java.util.List;

public class CommandDev extends CommandBase  {
    @Override
    public String getCommandName() { return "dev"; }

    @Override
    public String getCommandUsage(ICommandSender sender) { return "command.dev.usage"; }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
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
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return ExampleMod.getMainConfig().dev_command; }
}
