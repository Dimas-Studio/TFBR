/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package dimasicserver;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.network.simple.SimpleChannel;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.common.NeoForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

import dimasicserver.init.DimasicServerModTabs;
import dimasicserver.init.DimasicServerModSounds;
import dimasicserver.init.DimasicServerModItems;
import dimasicserver.init.DimasicServerModBlocks;

@Mod("dimasic_server")
public class DimasicServerMod {
	public static final Logger LOGGER = LogManager.getLogger(DimasicServerMod.class);
	public static final String MODID = "dimasic_server";

	public DimasicServerMod() {
		NeoForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		DimasicServerModSounds.REGISTRY.register(bus);
		DimasicServerModBlocks.REGISTRY.register(bus);
		DimasicServerModItems.REGISTRY.register(bus);
		DimasicServerModTabs.REGISTRY.register(bus);

	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
