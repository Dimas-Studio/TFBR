
package dimasicserver.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import dimasicserver.itemgroup.ServerStuffItemGroup;

import dimasicserver.DimasicServerModElements;

@DimasicServerModElements.ModElement.Tag
public class FlagItem extends DimasicServerModElements.ModElement {
	@ObjectHolder("dimasic_server:flag")
	public static final Item block = null;

	public FlagItem(DimasicServerModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ServerStuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("flag");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
