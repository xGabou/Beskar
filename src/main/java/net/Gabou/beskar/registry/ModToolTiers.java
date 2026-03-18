package net.Gabou.beskar.registry;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModToolTiers implements Tier {
    BESKAR(6144, 13.0F, 8.0F, 5, 28, () -> Ingredient.of(ModItems.BESKAR_INGOT.get()));

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int level;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModToolTiers(int uses, float speed, float attackDamageBonus, int level, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

