package net.Gabou.beskar.api.hazard;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@FunctionalInterface
public interface HelmetHazardImmunityRule {
    boolean isImmune(LivingEntity entity, ItemStack helmetStack, ResourceKey<Level> levelKey);
}

