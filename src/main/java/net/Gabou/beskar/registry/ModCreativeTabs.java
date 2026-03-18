package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Beskar.MODID);

    public static final RegistryObject<CreativeModeTab> BESKAR_TAB = CREATIVE_MODE_TABS.register("beskar_tab",
            () -> CreativeModeTab.builder()
                    .title(net.minecraft.network.chat.Component.translatable("creativetab.beskar.beskar_tab"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.BESKAR_SWORD.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BESKAR_HELMET.get());
                        output.accept(ModItems.BESKAR_CHESTPLATE.get());
                        output.accept(ModItems.BESKAR_LEGGINGS.get());
                        output.accept(ModItems.BESKAR_BOOTS.get());
                        output.accept(ModItems.BESKAR_SPEAR.get());
                        output.accept(ModItems.BESKAR_SWORD.get());
                        output.accept(ModItems.BESKAR_PICKAXE.get());
                        output.accept(ModItems.BESKAR_AXE.get());
                        output.accept(ModItems.BESKAR_SHOVEL.get());
                        output.accept(ModItems.BESKAR_HOE.get());
                    })
                    .build());

    private ModCreativeTabs() {
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

