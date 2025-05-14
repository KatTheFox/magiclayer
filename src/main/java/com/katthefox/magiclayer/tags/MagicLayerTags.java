package com.katthefox.magiclayer.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MagicLayerTags {
    public static final TagKey<Item> PAPER = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "papers"));
}
