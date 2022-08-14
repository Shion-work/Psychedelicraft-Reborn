package com.beeftaquitos.psychedelicraft.item;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.item.custom.AsbestosSwordItem;
import com.beeftaquitos.psychedelicraft.item.custom.CoalCokeItem;
import com.beeftaquitos.psychedelicraft.item.custom.DowsingRodItem;
import com.beeftaquitos.psychedelicraft.item.custom.ModArmorItem;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Psychedelicraft.MOD_ID);

    //ADD ITEMS HERE

    public static final RegistryObject<Item> EDIBLE = ITEMS.register("edible",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB).food(ModFoods.EDIBLE)));

    public static final RegistryObject<Item> RED_SHROOM = ITEMS.register("red_shroom",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB).food(ModFoods.RED_SHROOM)));

    public static final RegistryObject<Item> BROWN_SHROOM = ITEMS.register("brown_shroom",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB).food(ModFoods.BROWN_SHROOM)));

    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> JOINT = ITEMS.register("joint",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> CANNABIS_BUDS = ITEMS.register("cannabis_bud",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DRIED_CANNABIS_BUDS = ITEMS.register("dried_cannabis_bud",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> CANNABIS_LEAF = ITEMS.register("cannabis_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DRIED_CANNABIS_LEAF = ITEMS.register("dried_cannabis_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> TOBACCO_LEAF = ITEMS.register("tobacco_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DRIED_TOBACCO_LEAF = ITEMS.register("dried_tobacco_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> ASBESTOS_INGOT = ITEMS.register("asbestos_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> RAW_ASBESTOS = ITEMS.register("raw_asbestos",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB).durability(16)));

    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
            () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> ASBESTOS_SWORD = ITEMS.register("asbestos_sword",
            () -> new AsbestosSwordItem(ModTiers.ASBESTOS, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> ASBESTOS_PICKAXE = ITEMS.register("asbestos_pickaxe",
            () -> new PickaxeItem(ModTiers.ASBESTOS, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> ASBESTOS_SHOVEL = ITEMS.register("asbestos_shovel",
            () -> new ShovelItem(ModTiers.ASBESTOS, 0, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> ASBESTOS_AXE = ITEMS.register("asbestos_axe",
            () -> new AxeItem(ModTiers.ASBESTOS, 4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> ASBESTOS_HOE = ITEMS.register("asbestos_hoe",
            () -> new HoeItem(ModTiers.ASBESTOS, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> MOGUS_HELMET = ITEMS.register("mogus_helmet",
            () -> new ModArmorItem(ModArmorMaterials.MOGUS, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> MOGUS_CHESTPLATE = ITEMS.register("mogus_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MOGUS, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> MOGUS_LEGGINGS = ITEMS.register("mogus_leggings",
            () -> new ArmorItem(ModArmorMaterials.MOGUS, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> MOGUS_BOOTS = ITEMS.register("mogus_boots",
            () -> new ArmorItem(ModArmorMaterials.MOGUS, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));

    public static final RegistryObject<Item> GOLD_PLATED_MOGUS = ITEMS.register("gold_plated_mogus",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PSYCHEDELICRAFT_TAB)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
