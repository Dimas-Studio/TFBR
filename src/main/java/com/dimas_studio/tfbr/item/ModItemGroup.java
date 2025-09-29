package com.dimas_studio.tfbr.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dimas_studio.tfbr.block.ModBlocks.*;
import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

public class ModItemGroup {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> TFBR_TAB = CREATIVE_MODE_TABS.register("tfbr_tab",() -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("creativetab.tfbr_tab"))
            .icon(() -> RESPAWN_NAGA.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(RESPAWN_NAGA.get());
                output.accept(RESPAWN_LICH.get());
                output.accept(RESPAWN_HYDRA.get());
                output.accept(RESPAWN_UR_GHAST.get());
                output.accept(RESPAWN_SNOW_QUEEN.get());
            }).build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }

}
