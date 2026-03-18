package net.Gabou.beskar.registry;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.blockentity.BeskarBlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Beskar.MODID);

    public static final RegistryObject<BlockEntityType<BeskarBlastFurnaceBlockEntity>> BESKAR_BLAST_FURNACE_BE =
            BLOCK_ENTITIES.register("beskar_blast_furnace",
                    () -> BlockEntityType.Builder.of(BeskarBlastFurnaceBlockEntity::new, ModBlocks.BESKAR_BLAST_FURNACE.get()).build(null));

    private ModBlockEntities() {
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

