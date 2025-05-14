package com.katthefox.magiclayer.registries;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.katthefox.magiclayer.MagicLayer.MODID;

public class MagicLayerItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> BASIC_WAND = ITEMS.registerSimpleItem("basic_wand", new Item.Properties().stacksTo(1));
    public static final DeferredItem<BlockItem> WRITING_DESK = ITEMS.registerSimpleBlockItem("writing_desk",MagicLayerBlocks.WRITING_DESK);
}
