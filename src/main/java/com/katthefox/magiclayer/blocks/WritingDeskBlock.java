package com.katthefox.magiclayer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WritingDeskBlock extends Block implements EntityBlock {
    public WritingDeskBlock(@NotNull Properties properties){
        super(properties);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state){
        return new WritingDeskBlockEntity(pos,state);
    }
}
