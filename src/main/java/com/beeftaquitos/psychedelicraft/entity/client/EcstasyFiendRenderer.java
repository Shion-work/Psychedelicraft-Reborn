package com.beeftaquitos.psychedelicraft.entity.client;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.entity.custom.EcstasyFiendEntity;
import com.beeftaquitos.psychedelicraft.entity.variant.EcstasyFiendVariant;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class EcstasyFiendRenderer extends GeoEntityRenderer<EcstasyFiendEntity> {

    public static final Map<EcstasyFiendVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(EcstasyFiendVariant.class), (p_114874_) -> {
                p_114874_.put(EcstasyFiendVariant.DEFAULT,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.BLUE,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/blue_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.GREEN,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/green_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.PINK,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/pink_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.ORANGE,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/orange_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.YELLOW,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/yellow_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.GRAY,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/gray_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.LILAC,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/lilac_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.BLACK,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/black_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.WHITE,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/white_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.PURPLE,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/purple_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.BROWN,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/brown_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.CYAN,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/cyan_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.LIME,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/lime_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.BEIGE,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/beige_ecstasy_fiend.png"));
                p_114874_.put(EcstasyFiendVariant.SALMON,
                        new ResourceLocation(Psychedelicraft.MOD_ID, "textures/entity/ecstasy_fiend/salmon_ecstasy_fiend.png"));
            });

    public EcstasyFiendRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EcstasyFiendModel());
        this.shadowRadius = .05f;
    }

    @Override
    public ResourceLocation getTextureLocation(EcstasyFiendEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(EcstasyFiendEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}