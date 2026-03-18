package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.block.BeskarBlastFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CraftingTableBlock;
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
            () -> new CraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)
                    .strength(2.8F)
                    .sound(SoundType.NETHERITE_BLOCK)));

    private ModBlocks() {
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

