package net.Gabou.beskar.hazard;

import net.Gabou.beskar.api.hazard.HazardHelmetImmunityRegistry;
import net.Gabou.beskar.registry.ModBlocks;
import net.Gabou.beskar.registry.ModEffects;
import net.minecraft.core.BlockPos;
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
    private static final int CRYSTAL_NODE_RADIUS = 10;

    private MandaloreHazardService() {
    }

    public static void tickEntity(LivingEntity entity) {
        if (entity.level().isClientSide() || !(entity.level() instanceof ServerLevel)) {
            return;
        }

        if (entity.tickCount % TOXICITY_CHECK_INTERVAL != 0) {
            return;
        }

        if (!(entity instanceof ServerPlayer player)) {
            return;
        }

        if (player.isCreative() || player.isSpectator()) {
            return;
        }

        ResourceKey<Level> levelKey = entity.level().dimension();
        if (!isMandalore(levelKey)) {
            return;
        }

        if (HazardHelmetImmunityRegistry.isImmune(entity, levelKey)) {
            return;
        }

        int amplifier = getContaminationAmplifier(player);

        MobEffectInstance active = entity.getEffect(ModEffects.TOXIC_CONTAMINATION.get());
        if (active != null && active.getDuration() > 80 && active.getAmplifier() == amplifier) {
            return;
        }

        entity.addEffect(new MobEffectInstance(ModEffects.TOXIC_CONTAMINATION.get(), 180, amplifier, false, true, true));
    }

    private static boolean isMandalore(ResourceKey<Level> levelKey) {
        return MANDALORE_DIMENSION_ID.equals(levelKey.location());
    }

    private static int getContaminationAmplifier(ServerPlayer player) {
        BlockPos center = player.blockPosition();
        int radiusSq = CRYSTAL_NODE_RADIUS * CRYSTAL_NODE_RADIUS;

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-CRYSTAL_NODE_RADIUS, -CRYSTAL_NODE_RADIUS, -CRYSTAL_NODE_RADIUS),
                center.offset(CRYSTAL_NODE_RADIUS, CRYSTAL_NODE_RADIUS, CRYSTAL_NODE_RADIUS))) {
            if (center.distSqr(pos) > radiusSq) {
                continue;
            }

            if (player.serverLevel().getBlockState(pos).is(ModBlocks.GREEN_CRYSTAL_BLOCK.get())
                    || player.serverLevel().getBlockState(pos).is(ModBlocks.GREEN_CRYSTAL_CLUSTER.get())) {
                return 1;
            }
        }

        return 0;
    }
}

