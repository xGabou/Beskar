package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.block.BeskarBlastFurnaceBlock;
import net.Gabou.beskar.block.GreenCrystalClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Beskar.MODID);

    public static final RegistryObject<Block> BESKAR_ORE = BLOCKS.register("beskar_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 4.5F)
                    .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> BESKAR_BLAST_FURNACE = BLOCKS.register("beskar_blast_furnace",
            () -> new BeskarBlastFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)
                    .strength(3.5F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BESKAR_WORKBENCH = BLOCKS.register("beskar_workbench",
            () -> new SmithingTableBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE)
                    .strength(3.0F)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TOXIC_GREEN_CRYSTAL_CLUSTER = BLOCKS.register("toxic_green_crystal_cluster",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(2.0F, 3.0F)
                    .lightLevel(state -> 11)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GREEN_CRYSTAL_BLOCK = BLOCKS.register("green_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(1.6F, 2.8F)
                    .sound(SoundType.GLASS)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GREEN_CRYSTAL_BLOCK_FLOOR = BLOCKS.register("green_crystal_block_floor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(1.4F, 2.5F)
                    .sound(SoundType.GLASS)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GREEN_CRYSTAL_BLOCK_FLOOR_CRACKED = BLOCKS.register("green_crystal_block_floor_cracked",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(1.2F, 2.2F)
                    .sound(SoundType.GLASS)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STONY_CRYSTAL = BLOCKS.register("stony_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .mapColor(MapColor.STONE)
                    .strength(2.2F, 3.5F)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GREEN_CRYSTAL_CLUSTER = BLOCKS.register("green_crystal_cluster",
            () -> new GreenCrystalClusterBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(0.4F, 0.8F)
                    .sound(SoundType.GLASS)
                    .noCollission()
                    .requiresCorrectToolForDrops()));

    private ModBlocks() {
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

