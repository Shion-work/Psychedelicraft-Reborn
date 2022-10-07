package com.beeftaquitos.psychedelicraft.world.feature;
import com.beeftaquitos.psychedelicraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MOGUS_TREE =
            FeatureUtils.register("mogus", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.MOGUS_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.MOGUS_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> MOGUS_CHECKED = PlacementUtils.register("mogus_checked", MOGUS_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.MOGUS_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MOGUS_SPAWN =
            FeatureUtils.register("mogus_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MOGUS_CHECKED,
                            0.5F)), MOGUS_CHECKED));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MOGUS_FLOWER =
            FeatureUtils.register("mogus_flower", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MOGUS_FLOWER.get())))));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CHRYSOTILE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CHRYSOTILE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.CHRYSOTILE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CHRYSOTILE = FeatureUtils.register("chrysotile",
            Feature.ORE, new OreConfiguration(OVERWORLD_CHRYSOTILE, 9));

}