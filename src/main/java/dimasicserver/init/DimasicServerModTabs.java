
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DimasicServerModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("dimasic_server", "server_stuff"),
				builder -> builder.title(Component.translatable("item_group.dimasic_server.server_stuff")).icon(() -> new ItemStack(DimasicServerModBlocks.NAGARESPAWN.get())).displayItems((parameters, tabData) -> {
					tabData.accept(DimasicServerModBlocks.NAGARESPAWN.get().asItem());
					tabData.accept(DimasicServerModBlocks.LICHSPAWN.get().asItem());
					tabData.accept(DimasicServerModBlocks.HYDRASPAWN.get().asItem());
					tabData.accept(DimasicServerModBlocks.UR_GHASTSPAWN.get().asItem());
					tabData.accept(DimasicServerModBlocks.SNOWQUEENSPAWN.get().asItem());
					tabData.accept(DimasicServerModBlocks.MOON.get().asItem());
					tabData.accept(DimasicServerModBlocks.SABUDKA.get().asItem());
				})

		);
	}
}
