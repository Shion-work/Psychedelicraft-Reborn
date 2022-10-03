package com.beeftaquitos.psychedelicraft.block.custom;

import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CannabisPlantBlock extends CropBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public CannabisPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CANNABIS_SEEDS.get();
    }
}
