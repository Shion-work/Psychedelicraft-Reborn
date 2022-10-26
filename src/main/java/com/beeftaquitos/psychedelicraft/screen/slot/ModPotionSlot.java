package com.beeftaquitos.psychedelicraft.screen.slot;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModPotionSlot extends SlotItemHandler {
    public ModPotionSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if(stack.is(ModItems.FERMENTED_WHEAT.get()) || stack.is(ModItems.FERMENTED_SWEET_BERRIES.get()) || stack.is(ModItems.FERMENTED_SUGAR_CANE.get()))
            return true;
        return false;
    }
}