package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.effect.ToxicContaminationEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Beskar.MODID);

    public static final RegistryObject<MobEffect> TOXIC_CONTAMINATION =
            MOB_EFFECTS.register("toxic_contamination", ToxicContaminationEffect::new);

    private ModEffects() {
    }

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

