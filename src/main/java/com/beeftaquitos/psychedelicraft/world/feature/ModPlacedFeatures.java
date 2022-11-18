package com.beeftaquitos.psychedelicraft.world.feature;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> MOGUS_PLACED = PlacementUtils.register("mogus_placed",
            ModConfiguredFeatures.MOGUS_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> MOGUS_FLOWER_PLACED = PlacementUtils.register("mogus_flower_placed",
            ModConfiguredFeatures.MOGUS_FLOWER, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHRYSOTILE_PLACED = PlacementUtils.register("chrysotile_placed",
            ModConfiguredFeatures.CHRYSOTILE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> SUSPICIOUS_ORE_PLACED = PlacementUtils.register("suspicious_ore_placed",
            ModConfiguredFeatures.SUSPICIOUS_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
}