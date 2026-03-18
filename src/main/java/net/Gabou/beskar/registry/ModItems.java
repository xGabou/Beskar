package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.item.BeskarArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Beskar.MODID);

    public static final RegistryObject<Item> BESKAR_HELMET = ITEMS.register("beskar_helmet",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_CHESTPLATE = ITEMS.register("beskar_chestplate",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_LEGGINGS = ITEMS.register("beskar_leggings",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_BOOTS = ITEMS.register("beskar_boots",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BESKAR_SWORD = ITEMS.register("beskar_sword",
            () -> new SwordItem(ModToolTiers.BESKAR, 3, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_PICKAXE = ITEMS.register("beskar_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BESKAR, 1, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_AXE = ITEMS.register("beskar_axe",
            () -> new AxeItem(ModToolTiers.BESKAR, 5.0F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_SHOVEL = ITEMS.register("beskar_shovel",
            () -> new ShovelItem(ModToolTiers.BESKAR, 1.5F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_HOE = ITEMS.register("beskar_hoe",
            () -> new HoeItem(ModToolTiers.BESKAR, -4, 0.0F, new Item.Properties().fireResistant()));

    private ModItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

