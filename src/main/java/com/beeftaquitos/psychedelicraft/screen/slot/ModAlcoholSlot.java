package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModAlcoholSlot extends SlotItemHandler {
    public ModAlcoholSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(ModItems.BOTTLE_OF_RUM.get()) || stack.is(ModItems.BOTTLE_OF_WINE.get()) || stack.is(ModItems.BOTTLE_OF_BEER.get()))
            return true;
        return false;
    }
}