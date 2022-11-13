package com.beeftaquitos.psychedelicraft.entity;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.entity.custom.EcstasyFiendEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Psychedelicraft.MOD_ID);

    public static final RegistryObject<EntityType<EcstasyFiendEntity>> ECSTASY_FIEND =
            ENTITY_TYPES.register("ecstasy_fiend",
                    () -> EntityType.Builder.of(EcstasyFiendEntity::new, MobCategory.CREATURE)
                            .sized(.85f, 1.7f)
                            .build(new ResourceLocation(Psychedelicraft.MOD_ID, "ecstasy_fiend").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}