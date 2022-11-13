package com.beeftaquitos.psychedelicraft.villager;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Psychedelicraft.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Psychedelicraft.MOD_ID);

    public static final RegistryObject<PoiType> DRYING_TABLE_POI = POI_TYPES.register("drying_table_poi",
            () -> new PoiType("drying_table_poi",
                    PoiType.getBlockStates(ModBlocks.DRYING_TABLE.get()), 1, 1));

    public static final RegistryObject<VillagerProfession> DEALER =
            VILLAGER_PROFESSIONS.register("dealer",
                    () -> new VillagerProfession("dealer", DRYING_TABLE_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_NO));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, DRYING_TABLE_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}