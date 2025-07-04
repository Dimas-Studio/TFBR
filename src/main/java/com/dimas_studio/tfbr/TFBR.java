package com.dimas_studio.tfbr;

import com.dimas_studio.tfbr.block.ModBlocks;
import com.dimas_studio.tfbr.item.ModItemGroup;
import com.dimas_studio.tfbr.item.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TFBR.MODID)
public class TFBR
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tfbr";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry(action, tick));
    }

//    @SubscribeEvent
//    public void tick(ServerTickEvent event) {
//        if (event.phase == TickEvent.Phase.END) {
//            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
//            workQueue.forEach(work -> {
//                work.setValue(work.getValue() - 1);
//                if (work.getValue() == 0)
//                    actions.add(work);
//            });
//            actions.forEach(e -> e.getKey().run());
//            workQueue.removeAll(actions);
//        }
//    }
    public TFBR(IEventBus modEventBus, ModContainer modContainer)
    {
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItemGroup.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.addListener(this::onServerStarting);
    }

    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
        LOGGER.info(Config.HYDRA_TROPHY_BLOCK.get());
    }
}
