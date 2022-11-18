package com.beeftaquitos.psychedelicraft.world.gen;
import com.beeftaquitos.psychedelicraft.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.CHRYSOTILE_PLACED);

        if(event.getCategory() == Biome.BiomeCategory.THEEND) {
            base.add(ModPlacedFeatures.SUSPICIOUS_ORE_PLACED);
        }
    }
}