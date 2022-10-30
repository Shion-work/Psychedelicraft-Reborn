package com.beeftaquitos.psychedelicraft.util;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MOGUS_LOGS = tag("mogus_logs");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Psychedelicraft.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BOTTLES_OF_ALCOHOL = tag("bottles_of_alcohol");

        public static final TagKey<Item> DRYING_MATERIALS = tag("drying_materials");

        public static final TagKey<Item> MAGIC_SHROOMS = tag("magic_shrooms");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Psychedelicraft.MOD_ID, name));
        }
    }
}