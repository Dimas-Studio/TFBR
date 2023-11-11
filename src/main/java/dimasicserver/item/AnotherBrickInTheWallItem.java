
package dimasicserver.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import dimasicserver.init.DimasicServerModTabs;

public class AnotherBrickInTheWallItem extends RecordItem {
	public AnotherBrickInTheWallItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dimasic_server:another_brick_in_the_wall")), new Item.Properties().tab(DimasicServerModTabs.TAB_SERVER_STUFF).stacksTo(1).rarity(Rarity.RARE), 0);
	}
}
