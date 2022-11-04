package com.beeftaquitos.psychedelicraft.item.custom;

import com.beeftaquitos.psychedelicraft.item.ModItems;
import com.beeftaquitos.psychedelicraft.particle.ModParticles;
import com.beeftaquitos.psychedelicraft.util.ModTags;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class BongItem extends Item {
    public BongItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        BlockPos positionClicked = player.blockPosition();
        if(player.getOffhandItem().is(ModItems.DRIED_CANNABIS_BUDS.get())) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 10, 1));

            player.getOffhandItem().setCount(player.getOffhandItem().getCount() - 1);
            spawnFoundParticles(pContext, positionClicked);
        }
        return super.useOn(pContext);
    }

    private void spawnFoundParticles(UseOnContext pContext, BlockPos positionClicked) {

                pContext.getLevel().addParticle(ModParticles.SMOKING_PARTICLES.get(),
                        positionClicked.getX(), positionClicked.getY() + 1, positionClicked.getZ(),
                        0, 0.15d, 0);
    }
}
