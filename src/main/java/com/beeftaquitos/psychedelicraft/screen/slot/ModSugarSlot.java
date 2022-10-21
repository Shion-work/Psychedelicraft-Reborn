package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModSugarSlot extends SlotItemHandler {
    public ModSugarSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(Items.SUGAR))
            return true;
        return false;
    }
}