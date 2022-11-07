package com.beeftaquitos.psychedelicraft.item.custom;

import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class SmokingItem extends Item {
    public SmokingItem(Properties pProperties) {
        super(pProperties);
    }
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.CAMPFIRE_CRACKLE;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 64;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLivingEntity.getUseItem().setCount(pLivingEntity.getUseItem().getCount() - 1);
        return pStack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        onUseTick(pLevel, pPlayer, pPlayer.getItemInHand(pUsedHand), getUseDuration(pPlayer.getItemInHand(pUsedHand)));
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if(pRemainingUseDuration < 54 && ((getUseDuration(pStack) - pRemainingUseDuration) % 10 == 0))
            spawnSmokingParticles((Player) pLivingEntity);
    }

    private void spawnSmokingParticles(Player pPlayer) {
        Vec3 playerLookVector = pPlayer.getViewVector(0);
        double spawnX = pPlayer.getX()+playerLookVector.x();
        double spawnZ = pPlayer.getZ()+playerLookVector.z();

        pPlayer.getLevel().addParticle(ModParticles.SMOKING_PARTICLES.get(),
                spawnX, pPlayer.getY() + 1.5, spawnZ, 0, 0.1d, 0);
    }
}