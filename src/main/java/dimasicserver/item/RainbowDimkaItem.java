
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
public class RainbowDimkaItem extends DimasicServerModElements.ModElement {
	@ObjectHolder("dimasic_server:rainbow_dimka")
	public static final Item block = null;

	public RainbowDimkaItem(DimasicServerModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ServerStuffItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("rainbow_dimka");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
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
