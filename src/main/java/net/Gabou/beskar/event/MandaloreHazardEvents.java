package net.Gabou.beskar.event;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.hazard.MandaloreHazardService;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Beskar.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class MandaloreHazardEvents {
    private MandaloreHazardEvents() {
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        MandaloreHazardService.tickEntity(event.getEntity());
    }
}

