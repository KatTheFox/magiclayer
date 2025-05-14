package com.katthefox.magiclayer;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import static com.katthefox.magiclayer.registries.MagicLayerBlockEntities.BLOCK_ENTITY_TYPES;
import static com.katthefox.magiclayer.registries.MagicLayerBlocks.BLOCKS;
import static com.katthefox.magiclayer.registries.MagicLayerCreativeTabs.CREATIVE_MODE_TABS;
import static com.katthefox.magiclayer.registries.MagicLayerItems.ITEMS;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MagicLayer.MODID)
public class MagicLayer {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "magiclayer";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in
    // automatically.
    public MagicLayer(IEventBus modEventBus, ModContainer modContainer) {

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);

    }
}
