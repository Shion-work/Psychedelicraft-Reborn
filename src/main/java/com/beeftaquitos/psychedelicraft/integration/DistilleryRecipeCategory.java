package com.beeftaquitos.psychedelicraft.integration;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.block.ModBlocks;
import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.recipe.DistilleryRecipe;
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

public class DistilleryRecipeCategory implements IRecipeCategory<DistilleryRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Psychedelicraft.MOD_ID, "distilling");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Psychedelicraft.MOD_ID, "textures/gui/distillery_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public DistilleryRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 38, 11, 100, 70);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.DISTILLERY.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends DistilleryRecipe> getRecipeClass() {
        return DistilleryRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Distillery");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull DistilleryRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 73, 6).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 42, 6).addIngredients(Ingredient.of(Items.SUGAR));
        builder.addSlot(RecipeIngredientRole.INPUT, 42, 27).addIngredients(Ingredient.of(ModItems.EMPTY_BOTTLE.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 42, 48).addItemStack(recipe.getResultItem());
    }
}