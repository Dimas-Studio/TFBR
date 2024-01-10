package com.dimas_studio.tfbr.item;

import com.dimas_studio.tfbr.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dimas_studio.tfbr.TFBR.MODID;

public class ModItemGroup {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS  =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> TFBR_TAB = CREATIVE_MODE_TABS.register("tfbr_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RESPAWN_NAGA.get()))
                    .title(Component.translatable("creativetab.tdbr_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RESPAWN_NAGA.get());
                    })
                    .build());;

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
