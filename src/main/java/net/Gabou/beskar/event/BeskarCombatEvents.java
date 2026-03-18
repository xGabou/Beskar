package net.Gabou.beskar.event;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.item.BeskarArmorItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Beskar.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class BeskarCombatEvents {
    private static final String[] BLASTER_KEYWORDS = new String[] {
            "blaster",
            "blaster_rifle",
            "rifle",
            "bolt",
            "laser"
    };

    private BeskarCombatEvents() {
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();

        if (!isWearingFullBeskar(target)) {
            return;
        }

        if (isBlasterDamage(event.getSource())) {
            event.setCanceled(true);
        }
    }

    private static boolean isWearingFullBeskar(LivingEntity entity) {
        for (ItemStack armor : entity.getArmorSlots()) {
            if (!(armor.getItem() instanceof BeskarArmorItem)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isBlasterDamage(DamageSource damageSource) {
        if (containsKeyword(damageSource.getMsgId())) {
            return true;
        }

        Entity directEntity = damageSource.getDirectEntity();

        if (directEntity != null) {
            ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(directEntity.getType());

            if (entityId != null && containsKeyword(entityId.getPath())) {
                return true;
            }
        }

        ResourceKey<DamageType> damageTypeKey = damageSource.typeHolder().unwrapKey().orElse(null);

        if (damageTypeKey != null) {
            ResourceLocation damageTypeId = damageTypeKey.location();
            return containsKeyword(damageTypeId.getPath());
        }

        return false;
    }

    private static boolean containsKeyword(String value) {
        if (value == null || value.isBlank()) {
            return false;
        }

        String normalized = value.toLowerCase();

        for (String keyword : BLASTER_KEYWORDS) {
            if (normalized.contains(keyword)) {
                return true;
            }
        }

        return false;
    }
}

