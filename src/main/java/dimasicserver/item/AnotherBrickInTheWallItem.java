
package dimasicserver.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import dimasicserver.itemgroup.ServerStuffItemGroup;

import dimasicserver.DimasicServerModElements;

@DimasicServerModElements.ModElement.Tag
public class AnotherBrickInTheWallItem extends DimasicServerModElements.ModElement {
	@ObjectHolder("dimasic_server:another_brick_in_the_wall")
	public static final Item block = null;

	public AnotherBrickInTheWallItem(DimasicServerModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, DimasicServerModElements.sounds.get(new ResourceLocation("dimasic_server:another_brick_in_the_wall")),
					new Item.Properties().group(ServerStuffItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("another_brick_in_the_wall");
		}
	}
}
