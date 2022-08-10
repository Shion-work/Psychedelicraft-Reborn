package com.beeftaquitos.psychedelicraft.block;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.item.ModCreativeModeTab;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> BLUNT_BUNDLE = registerBlock("blunt_bundle",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

    public static final RegistryObject<Block> CHRYSOTILE = registerBlock("chrysotile",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.PSYCHEDELICRAFT_TAB);

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
