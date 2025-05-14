package com.katthefox.magiclayer.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static com.katthefox.magiclayer.MagicLayer.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class MagicLayerDatagenEvents {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(
                event.includeClient(),
                new MagicLayerBlockStateProvider(output, existingFileHelper));
        generator.addProvider(
                event.includeClient(), new MagicLayerItemModelProvider(output, existingFileHelper));
        generator.addProvider(
                event.includeClient(),
                new MagicLayerItemTagsProvider(
                        output,
                        lookupProvider,
                        CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()),
                        existingFileHelper));
    }
}
