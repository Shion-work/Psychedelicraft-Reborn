package com.beeftaquitos.psychedelicraft;

import com.beeftaquitos.psychedelicraft.block.ModBlockEntities;
import com.beeftaquitos.psychedelicraft.block.ModBlocks;
import com.beeftaquitos.psychedelicraft.effect.ModEffects;
import com.beeftaquitos.psychedelicraft.enchantment.ModEnchantments;
import com.beeftaquitos.psychedelicraft.entity.ModEntityTypes;
import com.beeftaquitos.psychedelicraft.entity.client.EcstasyFiendRenderer;
import com.beeftaquitos.psychedelicraft.fluid.ModFluids;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.painting.ModPaintings;
import com.beeftaquitos.psychedelicraft.particle.ModParticles;
import com.beeftaquitos.psychedelicraft.potion.ModPotions;
import com.beeftaquitos.psychedelicraft.recipe.ModRecipes;
import com.beeftaquitos.psychedelicraft.screen.*;
import com.beeftaquitos.psychedelicraft.sound.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Psychedelicraft.MOD_ID)
public class Psychedelicraft {
    public static final String MOD_ID = "psychedelicraft";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Psychedelicraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModPaintings.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);
        ModSounds.register(eventBus);
        ModRecipes.register(eventBus);
        ModParticles.register(eventBus);
        ModFluids.register(eventBus);
        ModEnchantments.register(eventBus);
        ModEntityTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        GeckoLib.initialize();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOGUS_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_MOGUS_FLOWER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOGUS_GLASS.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANNABIS_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOBACCO_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOGUS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOGUS_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModFluids.SUS_JUICE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.SUS_JUICE_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.SUS_JUICE_FLOWING.get(), RenderType.translucent());

        EntityRenderers.register(ModEntityTypes.ECSTASY_FIEND.get(), EcstasyFiendRenderer::new);

        MenuScreens.register(ModMenuTypes.DRYING_TABLE_MENU.get(), DryingTableScreen::new);
        MenuScreens.register(ModMenuTypes.SHROOM_BOX_MENU.get(), ShroomBoxScreen::new);
        MenuScreens.register(ModMenuTypes.DISTILLERY_MENU.get(), DistilleryScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MOGUS_FLOWER.getId(), ModBlocks.POTTED_MOGUS_FLOWER);
        });

        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.WHEAT), new ItemStack(ModItems.FERMENTED_WHEAT.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.SWEET_BERRIES), new ItemStack(ModItems.FERMENTED_SWEET_BERRIES.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.SUGAR_CANE), new ItemStack(ModItems.FERMENTED_SUGAR_CANE.get()));
    }
}