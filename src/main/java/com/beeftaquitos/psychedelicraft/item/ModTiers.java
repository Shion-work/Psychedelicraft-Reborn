package com.beeftaquitos.psychedelicraft.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier ASBESTOS = new ForgeTier(3, 2000, 1.5f, 2f, 22, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModItems.ASBESTOS_INGOT.get()));

    public static final ForgeTier MOGUS = new ForgeTier(5, 10000, 8f, 5f, 30, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.GOLD_PLATED_MOGUS.get()));

}
