package com.dimas_studio.tfbr.item;

import com.dimas_studio.tfbr.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.dimas_studio.tfbr.TFBR.MODID;
import static com.dimas_studio.tfbr.block.ModBlocks.RESPAWN_NAGA;

public class ModItemGroup {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS  =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TFBR_TAB = CREATIVE_MODE_TABS.register("tfbr_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> RESPAWN_NAGA.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(RESPAWN_NAGA.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
