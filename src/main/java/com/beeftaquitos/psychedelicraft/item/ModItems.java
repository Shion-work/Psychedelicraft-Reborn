package com.beeftaquitos.psychedelicraft.item;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Psychedelicraft.MOD_ID);

    //ADD ITEMS HERE

    public static final RegistryObject<Item> EDIBLE = ITEMS.register("edible",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> JOINT = ITEMS.register("joint",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> CANNABIS_BUDS = ITEMS.register("cannabis_buds",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DRIED_CANNABIS_BUDS = ITEMS.register("dried_cannabis_buds",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> CANNABIS_LEAF = ITEMS.register("cannabis_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DRIED_CANNABIS_LEAF = ITEMS.register("dried_cannabis_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> TOBACCO_LEAF = ITEMS.register("tobacco_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DRIED_TOBACCO_LEAF = ITEMS.register("dried_tobacco_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
