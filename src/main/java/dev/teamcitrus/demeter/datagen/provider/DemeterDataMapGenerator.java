package dev.teamcitrus.demeter.datagen.provider;

import dev.teamcitrus.demeter.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("deprecation")
public class DemeterDataMapGenerator extends DataMapProvider {
    public DemeterDataMapGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        Builder<Compostable, Item> compostables = builder(NeoForgeDataMaps.COMPOSTABLES);
        compostables.add(ItemRegistry.MAPLE_LEAVES.get().builtInRegistryHolder(), new Compostable(0.3f), false);
    }
}
