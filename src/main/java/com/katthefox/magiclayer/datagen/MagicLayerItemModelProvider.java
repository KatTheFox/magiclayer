package com.katthefox.magiclayer.datagen;

import com.katthefox.magiclayer.registries.MagicLayerItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.katthefox.magiclayer.MagicLayer.MODID;

public class MagicLayerItemModelProvider extends ItemModelProvider {
    public MagicLayerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(MagicLayerItems.BASIC_WAND.get());
    }
}
