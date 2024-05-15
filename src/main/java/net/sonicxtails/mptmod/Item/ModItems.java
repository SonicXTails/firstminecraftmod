package net.sonicxtails.mptmod.Item;

import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sonicxtails.mptmod.Item.material.NewArmorMaterials;
import net.sonicxtails.mptmod.MptMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MptMod.MOD_ID);

    public static final RegistryObject<Item> KEY = ITEMS.register("key",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> MAGNETITE_CRYSTAL = ITEMS.register("magnetite_crystal",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> MAGNETITE_STEEL_INGOT = ITEMS.register("magnetite_steel_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    // Rubyssssssssssss
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> RUBY_APPLE = ITEMS.register("ruby_apple",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(new NewArmorMaterials(), EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(new NewArmorMaterials(), EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(new NewArmorMaterials(), EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(new NewArmorMaterials(), EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));


    public static final RegistryObject<Item> RUBY_NUGGET = ITEMS.register("ruby_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));


    public static final RegistryObject<Item> RUBY_STEAK = ITEMS.register("ruby_steak",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));

    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(Tiers.RUBY, 5, 3.5f, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(Tiers.RUBY, 4, 3.5f, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(Tiers.RUBY, 3, 3.5f, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(Tiers.RUBY, 7, 3.5f, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(Tiers.RUBY, 1, 3.5f, new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));
    public static final RegistryObject<Item> RUBY_MULTITOOL = ITEMS.register("ruby_multitool",
            () -> new RubyMultiToolItem(new Item.Properties().tab(ModCreativeModeTab.MPT_TAB)));





    public static class Tiers{
        public static final Tier RUBY = new ForgeTier(4, 800, 3.5f, 3, 350, null, () -> Ingredient.EMPTY);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}