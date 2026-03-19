package net.Gabou.beskar.event;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.item.BeskarArmorItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Beskar.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class BeskarCombatEvents {
    private static final Set<String> GUN_MOD_NAMESPACES = Set.of(
            "warium",
            "tacz",
            "timeless_and_classics_zero",
            "timeless_and_classics_zero_guns"
    );
    private static final String[] GUNSHOT_KEYWORDS = new String[] {
            "blaster",
            "rifle",
            "bullet",
            "bolt",
            "laser",
            "gun",
            "shot",
            "projectile"
    };

    private BeskarCombatEvents() {
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();

        if (!isWearingFullBeskar(target)) {
            return;
        }

        if (isCompatGunDamage(event.getSource())) {
            reflectIncomingProjectile(target, event.getSource());
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

    private static boolean isCompatGunDamage(DamageSource damageSource) {
        Entity directEntity = damageSource.getDirectEntity();

        if (directEntity != null) {
            ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(directEntity.getType());

            if (entityId != null && isModGunProjectile(entityId)) {
                return true;
            }
        }

        Entity attacker = damageSource.getEntity();
        if (attacker != null) {
            ResourceLocation attackerId = ForgeRegistries.ENTITY_TYPES.getKey(attacker.getType());
            if (attackerId != null && isCompatNamespace(attackerId.getNamespace()) && containsKeyword(damageSource.getMsgId())) {
                return true;
            }
        }

        ResourceKey<DamageType> damageTypeKey = damageSource.typeHolder().unwrapKey().orElse(null);

        if (damageTypeKey != null) {
            ResourceLocation damageTypeId = damageTypeKey.location();

            if (isCompatNamespace(damageTypeId.getNamespace()) && containsKeyword(damageTypeId.getPath())) {
                return true;
            }
        }

        String msgId = normalize(damageSource.getMsgId());
        if (msgId.isEmpty()) {
            return false;
        }

        for (String namespace : GUN_MOD_NAMESPACES) {
            if (msgId.contains(namespace) && containsKeyword(msgId)) {
                return true;
            }
        }

        return false;
    }

    private static void reflectIncomingProjectile(LivingEntity target, DamageSource damageSource) {
        Entity directEntity = damageSource.getDirectEntity();
        if (!(directEntity instanceof Projectile projectile)) {
            return;
        }

        Entity attacker = damageSource.getEntity();
        Vec3 reflectedDirection;

        if (attacker != null && attacker.isAlive()) {
            reflectedDirection = attacker.getEyePosition().subtract(projectile.position()).normalize();
        } else {
            Vec3 incomingVelocity = projectile.getDeltaMovement();
            reflectedDirection = incomingVelocity.lengthSqr() > 1.0E-6D ? incomingVelocity.normalize().scale(-1.0D) : target.getLookAngle();
        }

        Vec3 currentVelocity = projectile.getDeltaMovement();
        double speed = Math.max(1.8D, currentVelocity.length());
        projectile.setDeltaMovement(reflectedDirection.scale(speed));
        projectile.hurtMarked = true;
        projectile.setOwner(target);
    }

    private static boolean isModGunProjectile(ResourceLocation entityId) {
        return isCompatNamespace(entityId.getNamespace()) && containsKeyword(entityId.getPath());
    }

    private static boolean isCompatNamespace(String namespace) {
        return namespace != null && GUN_MOD_NAMESPACES.contains(normalize(namespace));
    }

    private static boolean containsKeyword(String value) {
        String normalized = normalize(value);
        if (normalized.isEmpty()) {
            return false;
        }

        for (String keyword : GUNSHOT_KEYWORDS) {
            if (normalized.contains(keyword)) {
                return true;
            }
        }

        return false;
    }

    private static String normalize(String value) {
        return value == null ? "" : value.toLowerCase(Locale.ROOT);
    }
}

