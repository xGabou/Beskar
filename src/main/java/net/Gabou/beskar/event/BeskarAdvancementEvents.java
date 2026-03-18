package net.Gabou.beskar.event;

import net.Gabou.beskar.Beskar;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Beskar.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class BeskarAdvancementEvents {
    private static final Set<ResourceLocation> BLOCKED_VANILLA_ADVANCEMENTS = Set.of(
            ResourceLocation.parse("minecraft:adventure/throw_trident"),
            ResourceLocation.parse("minecraft:adventure/very_very_frightening"),
            ResourceLocation.parse("minecraft:nether/netherite_armor")
    );

    private BeskarAdvancementEvents() {
    }

    @SubscribeEvent
    public static void onAdvancementEarned(AdvancementEvent.AdvancementEarnEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        Advancement advancement = event.getAdvancement();
        ResourceLocation advancementId = advancement.getId();

        if (!BLOCKED_VANILLA_ADVANCEMENTS.contains(advancementId) || !isUsingBeskarGear(player)) {
            return;
        }

        AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
        List<String> completedCriteria = new ArrayList<>();
        progress.getCompletedCriteria().forEach(completedCriteria::add);

        for (String criterion : completedCriteria) {
            player.getAdvancements().revoke(advancement, criterion);
        }
    }

    private static boolean isUsingBeskarGear(ServerPlayer player) {
        if (isBeskarItem(player.getMainHandItem()) || isBeskarItem(player.getOffhandItem())) {
            return true;
        }

        for (ItemStack armorStack : player.getArmorSlots()) {
            if (isBeskarItem(armorStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isBeskarItem(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());
        return itemId != null && Beskar.MODID.equals(itemId.getNamespace());
    }
}


