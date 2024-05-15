package net.sonicxtails.mptmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sonicxtails.mptmod.Item.ModCreativeModeTab;
import net.sonicxtails.mptmod.Item.ModItems;
import net.sonicxtails.mptmod.MptMod;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MptMod.MOD_ID);


    // Magnetite
    public static final RegistryObject<Block> MAGNETITE_ORE = registryBlock("magnetite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.MPT_TAB);

    public static final RegistryObject<Block> MAGNETITE_CRYSTAL_BLOCK = registryBlock("magnetite_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MPT_TAB);

    public static final RegistryObject<Block> MAGNETITE_STEEL_BLOCK = registryBlock("magnetite_steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MPT_TAB);

    public static final RegistryObject<Block> MAGNETITE_DEEPSLATE_ORE = registryBlock("magnetite_deepslate_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.MPT_TAB);
    // Magnetite end

    // Ruby
    public static final RegistryObject<Block> RUBY_ORE = registryBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.MPT_TAB);

    public static final RegistryObject<Block> RUBY_BLOCK = registryBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.MPT_TAB);
    // Ruby end


    public static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    public static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){ BLOCKS.register(eventBus); }
}

