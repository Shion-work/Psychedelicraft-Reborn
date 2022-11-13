package com.beeftaquitos.psychedelicraft.entity.client;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import com.beeftaquitos.psychedelicraft.entity.custom.EcstasyFiendEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EcstasyFiendModel extends AnimatedGeoModel<EcstasyFiendEntity> {
    @Override
    public ResourceLocation getModelLocation(EcstasyFiendEntity object) {
        return new ResourceLocation(Psychedelicraft.MOD_ID, "geo/ecstasy_fiend.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EcstasyFiendEntity object) {
        return EcstasyFiendRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EcstasyFiendEntity animatable) {
        return new ResourceLocation(Psychedelicraft.MOD_ID, "animations/ecstasy_fiend.animation.json");
    }
}