package net.Gabou.beskar.api.hazard;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.registry.ModItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class HazardHelmetImmunityRegistry {
    private static final ResourceLocation TOXIC_HELMET_TAG_ID =
            ResourceLocation.fromNamespaceAndPath(Beskar.MODID, "toxic_protection_helmets");

    private static final List<HelmetHazardImmunityRule> RULES = new CopyOnWriteArrayList<>();
    private static boolean defaultsBootstrapped;

    private HazardHelmetImmunityRegistry() {
    }

    public static void bootstrapDefaults() {
        if (defaultsBootstrapped) {
            return;
        }

        register((entity, helmetStack, levelKey) -> helmetStack.is(ModItems.BESKAR_HELMET.get()));
        register((entity, helmetStack, levelKey) -> helmetStack.is(ItemTags.create(TOXIC_HELMET_TAG_ID)));
        defaultsBootstrapped = true;
    }

    public static void register(HelmetHazardImmunityRule rule) {
        RULES.add(rule);
    }

    public static boolean isImmune(LivingEntity entity, ResourceKey<Level> levelKey) {
        ItemStack helmetStack = entity.getItemBySlot(EquipmentSlot.HEAD);

        if (helmetStack.isEmpty()) {
            return false;
        }

        for (HelmetHazardImmunityRule rule : RULES) {
            if (rule.isImmune(entity, helmetStack, levelKey)) {
                return true;
            }
        }

        return false;
    }
}

