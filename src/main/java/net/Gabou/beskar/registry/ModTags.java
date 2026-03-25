package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModTags {
    private ModTags() {
    }

    public static final class Blocks {
        public static final TagKey<Block> GREEN_CRYSTAL_GROUND =
                BlockTags.create(ResourceLocation.fromNamespaceAndPath(Beskar.MODID, "green_crystal_ground"));

        private Blocks() {
        }
    }
}
