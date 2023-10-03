
package dimasicserver.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import dimasicserver.block.NagarespawnBlock;

import dimasicserver.DimasicServerModElements;

@DimasicServerModElements.ModElement.Tag
public class ServerStuffItemGroup extends DimasicServerModElements.ModElement {
	public ServerStuffItemGroup(DimasicServerModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabserver_stuff") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NagarespawnBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
