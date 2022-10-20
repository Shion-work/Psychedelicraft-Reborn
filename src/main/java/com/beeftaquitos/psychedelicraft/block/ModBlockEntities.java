package com.beeftaquitos.psychedelicraft.block;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.block.entity.DistilleryBlockEntity;
import com.beeftaquitos.psychedelicraft.block.entity.DryingTableBlockEntity;
import com.beeftaquitos.psychedelicraft.block.entity.ShroomBoxBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Psychedelicraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<DryingTableBlockEntity>> DRYING_TABLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("drying_table_block_entity", () ->
                    BlockEntityType.Builder.of(DryingTableBlockEntity::new,
                            ModBlocks.DRYING_TABLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ShroomBoxBlockEntity>> SHROOM_BOX_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("shroom_box_block_entity", () ->
                    BlockEntityType.Builder.of(ShroomBoxBlockEntity::new,
                            ModBlocks.SHROOM_BOX.get()).build(null));

    public static final RegistryObject<BlockEntityType<DistilleryBlockEntity>> DISTILLERY_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("distillery_block_entity", () ->
                    BlockEntityType.Builder.of(DistilleryBlockEntity::new,
                            ModBlocks.DISTILLERY.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}