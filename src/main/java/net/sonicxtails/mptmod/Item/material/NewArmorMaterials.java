package net.sonicxtails.mptmod.Item.material;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class NewArmorMaterials implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[]{14, 15, 17, 12};

    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return BASE_DURABILITY[equipmentSlot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return PROTECTION_VALUES[equipmentSlot.getIndex()]*7;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "ruby_armor";
    }

    @Override
    public float getToughness() {
        return 7.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.45f;
    }
}
