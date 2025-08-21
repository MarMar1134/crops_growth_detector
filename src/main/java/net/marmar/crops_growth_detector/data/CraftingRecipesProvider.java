package net.marmar.crops_growth_detector.data;

import net.marmar.crops_growth_detector.block.CPDBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class CraftingRecipesProvider extends RecipeProvider {
    public CraftingRecipesProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CPDBlocks.GROWTH_DETECTOR.get())
                .pattern(" T ")
                .pattern("RLR")
                .pattern("SSS")
                .define('T', Items.REDSTONE_TORCH)
                .define('R', Items.REDSTONE)
                .define('L', Items.QUARTZ)
                .define('S', Items.STONE)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(CPDBlocks.GROWTH_DETECTOR.get()), has(CPDBlocks.GROWTH_DETECTOR.get()))
                .save(consumer);
    }
}
