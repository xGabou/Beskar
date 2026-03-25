package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.item.BeskarArmorItem;
import net.Gabou.beskar.item.BeskarSpearItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Beskar.MODID);

    public static final RegistryObject<Item> RAW_BESKAR = ITEMS.register("raw_beskar", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_INGOT = ITEMS.register("beskar_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_COAL = ITEMS.register("beskar_coal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BESKAR_ORE = registerBlockItem("beskar_ore", ModBlocks.BESKAR_ORE);
    public static final RegistryObject<Item> BESKAR_BLAST_FURNACE = registerBlockItem("beskar_blast_furnace", ModBlocks.BESKAR_BLAST_FURNACE);
    public static final RegistryObject<Item> BESKAR_WORKBENCH = registerBlockItem("beskar_workbench", ModBlocks.BESKAR_WORKBENCH);
    public static final RegistryObject<Item> TOXIC_GREEN_CRYSTAL_CLUSTER = registerBlockItem("toxic_green_crystal_cluster", ModBlocks.TOXIC_GREEN_CRYSTAL_CLUSTER);
    public static final RegistryObject<Item> GREEN_CRYSTAL_BLOCK = registerBlockItem("green_crystal_block", ModBlocks.GREEN_CRYSTAL_BLOCK);
    public static final RegistryObject<Item> GREEN_CRYSTAL_BLOCK_FLOOR = registerBlockItem("green_crystal_block_floor", ModBlocks.GREEN_CRYSTAL_BLOCK_FLOOR);
    public static final RegistryObject<Item> GREEN_CRYSTAL_BLOCK_FLOOR_CRACKED = registerBlockItem("green_crystal_block_floor_cracked", ModBlocks.GREEN_CRYSTAL_BLOCK_FLOOR_CRACKED);
    public static final RegistryObject<Item> STONY_CRYSTAL = registerBlockItem("stony_crystal", ModBlocks.STONY_CRYSTAL);
    public static final RegistryObject<Item> GREEN_CRYSTAL_CLUSTER = registerBlockItem("green_crystal_cluster", ModBlocks.GREEN_CRYSTAL_CLUSTER);

    public static final RegistryObject<Item> BESKAR_HELMET = ITEMS.register("beskar_helmet",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_CHESTPLATE = ITEMS.register("beskar_chestplate",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_LEGGINGS = ITEMS.register("beskar_leggings",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_BOOTS = ITEMS.register("beskar_boots",
            () -> new BeskarArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BESKAR_SWORD = ITEMS.register("beskar_sword",
            () -> new SwordItem(ModToolTiers.BESKAR, 6, -2.3F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_PICKAXE = ITEMS.register("beskar_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BESKAR, 3, -2.7F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_AXE = ITEMS.register("beskar_axe",
            () -> new AxeItem(ModToolTiers.BESKAR, 8.0F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_SHOVEL = ITEMS.register("beskar_shovel",
            () -> new ShovelItem(ModToolTiers.BESKAR, 3.5F, -2.9F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_HOE = ITEMS.register("beskar_hoe",
            () -> new HoeItem(ModToolTiers.BESKAR, -2, 0.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BESKAR_SPEAR = ITEMS.register("beskar_spear",
            () -> new BeskarSpearItem(new Item.Properties().fireResistant()));

    private ModItems() {
    }

    private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<net.minecraft.world.level.block.Block> block) {
        return ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

