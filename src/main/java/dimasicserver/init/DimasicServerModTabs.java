
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class DimasicServerModTabs {
	public static CreativeModeTab TAB_SERVER_STUFF;

	public static void load() {
		TAB_SERVER_STUFF = new CreativeModeTab("tabserver_stuff") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(DimasicServerModBlocks.NAGARESPAWN.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
