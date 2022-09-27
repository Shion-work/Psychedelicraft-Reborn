package com.beeftaquitos.psychedelicraft.painting;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTOVIES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Psychedelicraft.MOD_ID);

    public static final RegistryObject<Motive> AMONG =
            PAINTING_MOTOVIES.register("among", () -> new Motive(48, 48));

    public static final RegistryObject<Motive> DINO =
            PAINTING_MOTOVIES.register("dino", () -> new Motive(32, 32));

    public static final RegistryObject<Motive> MINION =
            PAINTING_MOTOVIES.register("minion", () -> new Motive(32, 16));

    public static final RegistryObject<Motive> SKULL =
            PAINTING_MOTOVIES.register("skull", () -> new Motive(16, 32));

    public static final RegistryObject<Motive> STONER =
            PAINTING_MOTOVIES.register("stoner", () -> new Motive(16, 16));

    public static final RegistryObject<Motive> WALT =
            PAINTING_MOTOVIES.register("walt", () -> new Motive(16, 16));

    public static final RegistryObject<Motive> GUS =
            PAINTING_MOTOVIES.register("gus", () -> new Motive(32, 32));

    public static void register(IEventBus eventBus) {
        PAINTING_MOTOVIES.register(eventBus);
    }
}
