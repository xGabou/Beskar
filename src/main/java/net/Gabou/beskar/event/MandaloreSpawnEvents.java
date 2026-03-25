package net.Gabou.beskar.event;

import net.Gabou.beskar.Beskar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Beskar.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class MandaloreSpawnEvents {
    private static final ResourceLocation MANDALORE_DIMENSION =
            ResourceLocation.fromNamespaceAndPath("customplanets", "planet_mandalore");

    private MandaloreSpawnEvents() {
    }

    @SubscribeEvent
    public static void onMobPositionCheck(MobSpawnEvent.PositionCheck event) {
        if (!MANDALORE_DIMENSION.equals(event.getLevel().getLevel().dimension().location())) {
            return;
        }

        if (event.getSpawnType() != MobSpawnType.NATURAL && event.getSpawnType() != MobSpawnType.CHUNK_GENERATION) {
            return;
        }

        Mob mob = event.getEntity();
        MobCategory category = mob.getType().getCategory();
        if (category == MobCategory.CREATURE
                || category == MobCategory.AMBIENT
                || category == MobCategory.WATER_AMBIENT
                || category == MobCategory.WATER_CREATURE
                || category == MobCategory.UNDERGROUND_WATER_CREATURE
                || category == MobCategory.AXOLOTLS) {
            event.setResult(Event.Result.DENY);
        }
    }
}
