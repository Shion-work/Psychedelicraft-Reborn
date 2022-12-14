package com.beeftaquitos.psychedelicraft.event;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.entity.ModEntityTypes;
import com.beeftaquitos.psychedelicraft.entity.custom.EcstasyFiendEntity;
import com.beeftaquitos.psychedelicraft.event.loot.*;
import com.beeftaquitos.psychedelicraft.particle.ModParticles;
import com.beeftaquitos.psychedelicraft.particle.custom.SmokingParticles;
import com.beeftaquitos.psychedelicraft.recipe.DistilleryRecipe;
import com.beeftaquitos.psychedelicraft.recipe.DryingTableRecipe;
import com.beeftaquitos.psychedelicraft.recipe.ShroomBoxRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Psychedelicraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new CannabisSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"cannabis_seeds_from_grass")),

                new TobaccoSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"tobacco_seeds_from_grass")),

                new BluntFromVillagersAdditionModifer.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"blunt_from_villager")),

                new JointFromVillagersAdditionModifer.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"joint_from_villager")),

                new MogusTrapMusicDiscInIglooAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"mogus_trap_music_disc_in_igloo")),

                new SbobMusicDiscInShipwreckTreasureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"sbob_music_disc_in_shipwreck_treasure")),

                new EnjoyMinecraftMusicDiscInEndCityTreasureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"enjoy_minecraft_music_disc_in_end_city_treasure")),

                new RedShroomsFromRedMushroomsAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"red_shrooms_from_red_mushrooms")),

                new BrownShroomsFromBrownMushroomsAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Psychedelicraft.MOD_ID,"brown_shrooms_from_brown_mushrooms"))
        );
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, DryingTableRecipe.Type.ID, DryingTableRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, ShroomBoxRecipe.Type.ID, ShroomBoxRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, DistilleryRecipe.Type.ID, DistilleryRecipe.Type.INSTANCE);
    }


    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SMOKING_PARTICLES.get(),
                SmokingParticles.Provider::new);
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.ECSTASY_FIEND.get(), EcstasyFiendEntity.setAttributes());
    }
}