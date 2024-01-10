package com.dimas_studio.tfbr.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.dimas_studio.tfbr.TFBR.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);


    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
