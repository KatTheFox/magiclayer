package com.katthefox.magiclayer.registries;

import com.katthefox.magiclayer.blocks.WritingDeskBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.katthefox.magiclayer.MagicLayer.MODID;

public class MagicLayerBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<WritingDeskBlock> WRITING_DESK = BLOCKS.register("writing_desk", () -> new WritingDeskBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)));

}
