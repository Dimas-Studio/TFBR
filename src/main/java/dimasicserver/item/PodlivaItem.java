
package dimasicserver.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import dimasicserver.init.DimasicServerModTabs;

public class PodlivaItem extends Item {
	public PodlivaItem() {
		super(new Item.Properties().tab(DimasicServerModTabs.TAB_SERVER_STUFF).stacksTo(64).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}
