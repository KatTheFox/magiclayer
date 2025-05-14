package com.katthefox.magiclayer.registries;

import com.katthefox.magiclayer.blocks.WritingDeskBlock;
import com.katthefox.magiclayer.blocks.WritingDeskBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.katthefox.magiclayer.MagicLayer.MODID;

public class MagicLayerBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE,MODID);
    public static final Supplier<BlockEntityType<WritingDeskBlockEntity>> WRITING_DESK = BLOCK_ENTITY_TYPES.register(
            "writing_desk",
            ()->BlockEntityType.Builder.of(
                    WritingDeskBlockEntity::new,
                    MagicLayerBlocks.WRITING_DESK.get()
            ).build(null)
    );
}
