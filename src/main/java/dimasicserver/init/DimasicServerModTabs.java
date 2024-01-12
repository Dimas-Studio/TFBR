
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import dimasicserver.DimasicServerMod;

public class DimasicServerModTabs {
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REGISTRY = DeferredHolder.create(Registries.CREATIVE_MODE_TAB, DimasicServerMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SERVER_STUFF = REGISTRY.register("server_stuff",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.dimasic_server.server_stuff")).icon(() -> new ItemStack(DimasicServerModBlocks.NAGARESPAWN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DimasicServerModBlocks.SABUDKA.get().asItem());
				tabData.accept(DimasicServerModBlocks.MOON.get().asItem());
				tabData.accept(DimasicServerModBlocks.NAGARESPAWN.get().asItem());
				tabData.accept(DimasicServerModBlocks.LICHSPAWN.get().asItem());
				tabData.accept(DimasicServerModBlocks.HYDRASPAWN.get().asItem());
				tabData.accept(DimasicServerModBlocks.UR_GHASTSPAWN.get().asItem());
				tabData.accept(DimasicServerModBlocks.SNOWQUEENSPAWN.get().asItem());
				tabData.accept(DimasicServerModItems.ANOTHER_BRICK_IN_THE_WALL.get());
			})

					.build());
}
