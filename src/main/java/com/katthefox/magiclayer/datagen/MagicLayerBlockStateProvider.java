package com.katthefox.magiclayer.datagen;

import com.katthefox.magiclayer.registries.MagicLayerBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.katthefox.magiclayer.MagicLayer.MODID;

public class MagicLayerBlockStateProvider extends BlockStateProvider {
    public MagicLayerBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile writingDeskModel = models().cubeAll(MagicLayerBlocks.WRITING_DESK.getId().getPath(), blockTexture(Blocks.DARK_OAK_PLANKS));
        simpleBlockWithItem(MagicLayerBlocks.WRITING_DESK.get(), writingDeskModel);
    }
}
