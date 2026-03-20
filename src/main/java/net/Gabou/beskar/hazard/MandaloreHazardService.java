package net.Gabou.beskar.hazard;

import net.Gabou.beskar.api.hazard.HazardHelmetImmunityRegistry;
import net.Gabou.beskar.registry.ModEffects;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public final class MandaloreHazardService {
    private static final ResourceLocation MANDALORE_DIMENSION_ID =
            ResourceLocation.fromNamespaceAndPath("customplanets", "planet_mandalore");
    private static final int TOXICITY_CHECK_INTERVAL = 40;

    private MandaloreHazardService() {
    }

    public static void tickEntity(LivingEntity entity) {
        if (entity.level().isClientSide() || !(entity.level() instanceof ServerLevel)) {
            return;
        }

        if (entity.tickCount % TOXICITY_CHECK_INTERVAL != 0) {
            return;
        }

        if (entity instanceof ServerPlayer player && (player.isCreative() || player.isSpectator())) {
            return;
        }

        ResourceKey<Level> levelKey = entity.level().dimension();
        if (!isMandalore(levelKey)) {
            return;
        }

        if (HazardHelmetImmunityRegistry.isImmune(entity, levelKey)) {
            return;
        }

        MobEffectInstance active = entity.getEffect(ModEffects.TOXIC_CONTAMINATION.get());
        if (active != null && active.getDuration() > 80) {
            return;
        }

        entity.addEffect(new MobEffectInstance(ModEffects.TOXIC_CONTAMINATION.get(), 180, 0, false, true, true));
    }

    private static boolean isMandalore(ResourceKey<Level> levelKey) {
        return MANDALORE_DIMENSION_ID.equals(levelKey.location());
    }
}

