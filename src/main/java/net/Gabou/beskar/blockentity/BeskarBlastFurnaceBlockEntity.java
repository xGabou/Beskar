package net.Gabou.beskar.blockentity;

import net.Gabou.beskar.registry.ModBlockEntities;
import net.Gabou.beskar.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BeskarBlastFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public BeskarBlastFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.BESKAR_BLAST_FURNACE_BE.get(), blockPos, blockState, RecipeType.BLASTING);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.beskar.beskar_blast_furnace");
    }

    @Override
    protected int getBurnDuration(ItemStack fuel) {
        return fuel.is(ModItems.BESKAR_COAL.get()) ? 3200 : 0;
    }


    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new BlastFurnaceMenu(id, inventory, this, this.dataAccess);
    }
}

