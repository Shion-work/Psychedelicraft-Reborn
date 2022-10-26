package com.beeftaquitos.psychedelicraft.integration;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.recipe.DistilleryRecipe;
import com.beeftaquitos.psychedelicraft.recipe.DryingTableRecipe;
import com.beeftaquitos.psychedelicraft.recipe.ShroomBoxRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPsychedelicraftPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Psychedelicraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                DryingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                DistilleryRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                ShroomBoxRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<DryingTableRecipe> DryingTableRecipes = rm.getAllRecipesFor(DryingTableRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(DryingTableRecipeCategory.UID, DryingTableRecipe.class), DryingTableRecipes);

        List<DistilleryRecipe> DistilleryRecipes = rm.getAllRecipesFor(DistilleryRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(DistilleryRecipeCategory.UID, DistilleryRecipe.class), DistilleryRecipes);

        List<ShroomBoxRecipe> ShroomBoxRecipes = rm.getAllRecipesFor(ShroomBoxRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(ShroomBoxRecipeCategory.UID, ShroomBoxRecipe.class), ShroomBoxRecipes);
    }
}