package com.katthefox.magiclayer.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.katthefox.magiclayer.MagicLayer.MODID;

public class MagicLayerCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    // Creates a creative tab with the id "magiclayer:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGICLAYER_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.magiclayer")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> MagicLayerItems.WRITING_DESK.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(MagicLayerItems.BASIC_WAND.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(MagicLayerItems.WRITING_DESK.get());
            }).build());
}
