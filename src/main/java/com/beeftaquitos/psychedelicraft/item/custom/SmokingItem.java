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
        pLivingEntity.getItemInHand(InteractionHand.MAIN_HAND).setCount(pLivingEntity.getItemInHand(InteractionHand.MAIN_HAND).getCount() - 1);
        return pStack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if(pPlayer.getOffhandItem().isEmpty()) {
            pPlayer.startUsingItem(pUsedHand);

            spawnSmokingParticles(pPlayer);

            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    private void spawnSmokingParticles(Player pPlayer) {
        for(int i = 0; i < 5; i++) {
            pPlayer.getLevel().addParticle(ModParticles.SMOKING_PARTICLES.get(),
                    pPlayer.getX(), pPlayer.getEyeY(), pPlayer.getZ(), 0, 0.1d, 0);
        }
    }
}
