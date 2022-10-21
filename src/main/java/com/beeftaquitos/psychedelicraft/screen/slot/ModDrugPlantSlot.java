package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModDrugPlantSlot extends SlotItemHandler {
    public ModDrugPlantSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(ModItems.CANNABIS_BUDS.get()) || stack.is(ModItems.CANNABIS_LEAF.get()) || stack.is(ModItems.TOBACCO_LEAF.get()))
            return true;
        return false;
    }
}