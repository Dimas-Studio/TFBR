
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import dimasicserver.item.AnotherBrickInTheWallItem;

import dimasicserver.DimasicServerMod;

public class DimasicServerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DimasicServerMod.MODID);
	public static final RegistryObject<Item> SABUDKA = block(DimasicServerModBlocks.SABUDKA);
	public static final RegistryObject<Item> MOON = block(DimasicServerModBlocks.MOON);
	public static final RegistryObject<Item> NAGARESPAWN = block(DimasicServerModBlocks.NAGARESPAWN);
	public static final RegistryObject<Item> LICHSPAWN = block(DimasicServerModBlocks.LICHSPAWN);
	public static final RegistryObject<Item> HYDRASPAWN = block(DimasicServerModBlocks.HYDRASPAWN);
	public static final RegistryObject<Item> UR_GHASTSPAWN = block(DimasicServerModBlocks.UR_GHASTSPAWN);
	public static final RegistryObject<Item> SNOWQUEENSPAWN = block(DimasicServerModBlocks.SNOWQUEENSPAWN);
	public static final RegistryObject<Item> ANOTHER_BRICK_IN_THE_WALL = REGISTRY.register("another_brick_in_the_wall", () -> new AnotherBrickInTheWallItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
