package com.beeftaquitos.psychedelicraft.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class AsbestosSwordItem extends SwordItem {
    public AsbestosSwordItem(Tier pTier, int pAttackDamageModifer, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifer, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 200), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
