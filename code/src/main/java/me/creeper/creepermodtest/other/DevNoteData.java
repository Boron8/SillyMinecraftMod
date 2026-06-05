package me.creeper.creepermodtest.other;

import me.creeper.creepermodtest.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class DevNoteData {
    public static int num = 0;

    public int number;
    public String[] text;
    public int weight;


    public DevNoteData(int number, String[] text, int weight) {
        this.text = text;
        this.number = number;
        this.weight = weight;
    }

    public DevNoteData(String[] text, int weight) {
        this(++num, text, weight);
    }


    public DevNoteData(String[] text) {
        this(++num, text, 8);
    }

    public static ItemStack toItemStack(DevNoteData noteData) {
        ItemStack stack = new ItemStack(ModItems.itemDevNote);

        stack.setStackDisplayName("Dev Note #" + noteData.number);

        for (String lore : noteData.text) {
            addLore(stack, lore);
        }

        return stack;
    }


    public static ItemStack addLore(ItemStack stack, String text) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }

        NBTTagCompound display = tag.getCompoundTag("display");
        NBTTagList lore = new NBTTagList();

        lore.appendTag(new NBTTagString(text));

        display.setTag("Lore", lore);
        tag.setTag("display", display);

        return stack;
    }
}
