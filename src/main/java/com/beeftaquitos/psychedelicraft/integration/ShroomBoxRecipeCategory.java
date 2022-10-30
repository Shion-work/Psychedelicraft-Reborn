package com.beeftaquitos.psychedelicraft.integration;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.block.ModBlocks;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.recipe.ShroomBoxRecipe;
import com.beeftaquitos.psychedelicraft.util.ModTags;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class ShroomBoxRecipeCategory implements IRecipeCategory<ShroomBoxRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Psychedelicraft.MOD_ID, "juicing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Psychedelicraft.MOD_ID, "textures/gui/shroom_box_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ShroomBoxRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 33, 12, 110, 70);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.SHROOM_BOX.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends ShroomBoxRecipe> getRecipeClass() {
        return ShroomBoxRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Shroom Box");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull ShroomBoxRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 28).addIngredients(Ingredient.of(ModTags.Items.BOTTLES_OF_ALCOHOL));
        builder.addSlot(RecipeIngredientRole.INPUT, 24, 6).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 70, 6).addIngredients(Ingredient.of(ModItems.GOLD_PLATED_MOGUS.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 47, 48).addItemStack(recipe.getResultItem());
    }
}