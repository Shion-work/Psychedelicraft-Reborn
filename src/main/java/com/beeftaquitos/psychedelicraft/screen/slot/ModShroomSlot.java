package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModShroomSlot extends SlotItemHandler {
    public ModShroomSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(ModItems.RED_SHROOM.get()) || stack.is(ModItems.BROWN_SHROOM.get()))
            return true;
        return false;
    }
}