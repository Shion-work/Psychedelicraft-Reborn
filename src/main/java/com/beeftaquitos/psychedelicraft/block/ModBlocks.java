package com.beeftaquitos.psychedelicraft.block;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.block.custom.CannabisPlantBlock;
import com.beeftaquitos.psychedelicraft.block.custom.DryingTableBlock;
import com.beeftaquitos.psychedelicraft.block.custom.ModFlammableRotatedPillarBlock;
import com.beeftaquitos.psychedelicraft.block.custom.SpeedyBlock;
import com.beeftaquitos.psychedelicraft.item.ModCreativeModeTab;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.sound.ModSounds;
import com.beeftaquitos.psychedelicraft.world.feature.tree.MogusTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Psychedelicraft.MOD_ID);

    //ADD BLOCKS HERE

    public static final RegistryObject<Block> EDIBLE_BLOCK = registerBlock("edible_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> BLUNT_BUNDLE = registerBlock("blunt_bundle",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TNT).instabreak()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> CHRYSOTILE = registerBlock("chrysotile",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> DRYING_TABLE = registerBlock("drying_table",
            () -> new DryingTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
                    ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_STAIRS = registerBlock("mogus_stairs",
            () -> new StairBlock(() -> ModBlocks.MOGUS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(ModSounds.MOGUS_SOUNDS)), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_SLAB = registerBlock("mogus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(ModSounds.MOGUS_SOUNDS)), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_FENCE = registerBlock("mogus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(ModSounds.MOGUS_SOUNDS)), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_FENCE_GATE = registerBlock("mogus_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(ModSounds.MOGUS_SOUNDS)), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_FLOWER = registerBlock("mogus_flower",
            () -> new FlowerBlock(MobEffects.HUNGER, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> POTTED_MOGUS_FLOWER = registerBlockWithoutBlockItem("potted_mogus_flower",
            () -> new FlowerPotBlock(null, ModBlocks.MOGUS_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> MOGUS_GLASS = registerBlock("mogus_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(ModSounds.MOGUS_SOUNDS)), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> CANNABIS_PLANT = registerBlockWithoutBlockItem("cannabis_plant",
            () -> new CannabisPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> MOGUS_LOG = registerBlock("mogus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(ModSounds.MOGUS_SOUNDS)),
            ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_WOOD = registerBlock("mogus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(ModSounds.MOGUS_SOUNDS)),
            ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> STRIPPED_MOGUS_LOG = registerBlock("stripped_mogus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(ModSounds.MOGUS_SOUNDS)),
            ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> STRIPPED_MOGUS_WOOD = registerBlock("stripped_mogus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(ModSounds.MOGUS_SOUNDS)),
            ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_PLANKS = registerBlock("mogus_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ModSounds.MOGUS_SOUNDS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_LEAVES = registerBlock("mogus_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(ModSounds.MOGUS_SOUNDS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> MOGUS_SAPLING = registerBlock("mogus_sapling",
            () -> new SaplingBlock(new MogusTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(ModSounds.MOGUS_SOUNDS)),
            ModCreativeModeTab.PSYCHEDELICRAFT_TAB);



    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
