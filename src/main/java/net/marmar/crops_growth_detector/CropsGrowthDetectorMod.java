package net.marmar.crops_growth_detector;

import net.marmar.crops_growth_detector.block.CPDBlocks;
import net.marmar.crops_growth_detector.data.DataGenerators;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CropsGrowthDetectorMod.MOD_ID)
@SuppressWarnings("all")
public class CropsGrowthDetectorMod {
    public static final String MOD_ID = "crops_growth_detector";

    public CropsGrowthDetectorMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModList modList = ModList.get();
        if (!modList.isLoaded("enhanced_playthrough")){
            modEventBus.addListener(DataGenerators::gatherData);
        }

        CPDBlocks.register(modEventBus);
    }
}
