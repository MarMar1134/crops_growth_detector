package net.marmar.crops_growth_detector.block;

import net.marmar.crops_growth_detector.CropsGrowthDetectorMod;
import net.marmar.crops_growth_detector.block.growthdetector.GrowthDetectorBlock;
import net.marmar.crops_growth_detector.block.growthdetector.GrowthDetectorBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CPDBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CropsGrowthDetectorMod.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CropsGrowthDetectorMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CropsGrowthDetectorMod.MOD_ID);

    public static final RegistryObject<Block> GROWTH_DETECTOR = registerBlockWithItem("growth_detector",
            () -> new GrowthDetectorBlock(BlockBehaviour.Properties.copy(Blocks.COMPARATOR).noOcclusion()));
    public static final RegistryObject<BlockEntityType<GrowthDetectorBlockEntity>> GROWTH_DETECTOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("growth_detector_block", () -> BlockEntityType
                    .Builder.of(GrowthDetectorBlockEntity::new, CPDBlocks.GROWTH_DETECTOR.get()).build(null));

    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> block){
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, ToReturn);
        return ToReturn;
    }

    private static <T extends Block> void RegisterBlockItem(String name, RegistryObject<T> block){
        BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
    }
}
