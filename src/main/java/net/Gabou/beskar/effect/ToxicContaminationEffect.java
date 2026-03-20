package net.Gabou.beskar.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public final class ToxicContaminationEffect extends MobEffect {
    public ToxicContaminationEffect() {
        super(MobEffectCategory.HARMFUL, 0x48FF68);
        addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                "af8a85e3-09e8-40f4-bdd7-9722e1b4e14e",
                -2.0D,
                AttributeModifier.Operation.ADDITION
        );
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        float damage = 1.0F + (amplifier * 0.5F);
        entity.hurt(entity.damageSources().magic(), damage);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int period = Math.max(20, 50 - amplifier * 5);
        return duration % period == 0;
    }
}

