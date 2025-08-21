package net.marmar.crops_growth_detector.data;

import net.marmar.crops_growth_detector.CropsGrowthDetectorMod;
import net.marmar.crops_growth_detector.block.CPDBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CropsGrowthDetectorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddToTabs {
    @SubscribeEvent
    public static void addToTab(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey().equals(CreativeModeTabs.REDSTONE_BLOCKS)){
            event.getEntries().putAfter(Items.COMPARATOR.getDefaultInstance(), CPDBlocks.GROWTH_DETECTOR.get().asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
