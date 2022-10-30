package com.beeftaquitos.psychedelicraft;

import com.beeftaquitos.psychedelicraft.block.ModBlockEntities;
import com.beeftaquitos.psychedelicraft.block.ModBlocks;
import com.beeftaquitos.psychedelicraft.effect.ModEffects;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.painting.ModPaintings;
import com.beeftaquitos.psychedelicraft.potion.ModPotions;
import com.beeftaquitos.psychedelicraft.recipe.ModRecipes;
import com.beeftaquitos.psychedelicraft.screen.*;
import com.beeftaquitos.psychedelicraft.sound.ModSounds;
import com.beeftaquitos.psychedelicraft.util.BetterBrewingRecipe;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.stream.Collectors;

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

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);


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