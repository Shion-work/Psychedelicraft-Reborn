package com.beeftaquitos.psychedelicraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties EDIBLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(.02f).effect(new MobEffectInstance(MobEffects.HUNGER, 1200, 0), 1).alwaysEat().build();
    public static final FoodProperties RED_SHROOM = (new FoodProperties.Builder()).nutrition(2).saturationMod(.02f).effect(new MobEffectInstance(MobEffects.HUNGER, 1200, 0), 1).alwaysEat().build();
    public static final FoodProperties BROWN_SHROOM = (new FoodProperties.Builder()).nutrition(2).saturationMod(.02f).effect(new MobEffectInstance(MobEffects.HUNGER, 1200, 0), 1).alwaysEat().build();
}
