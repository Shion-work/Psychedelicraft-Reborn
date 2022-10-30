package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.util.ModTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModAlcoholSlot extends SlotItemHandler {
    public ModAlcoholSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(ModTags.Items.BOTTLES_OF_ALCOHOL))
            return true;
        return false;
    }
}