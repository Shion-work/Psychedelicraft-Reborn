package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class ModEmptyBottleSlot extends SlotItemHandler {
    public ModEmptyBottleSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(ModItems.EMPTY_BOTTLE.get()))
            return true;
        return false;
    }
}