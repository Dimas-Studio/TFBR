
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import dimasicserver.block.SabudkaBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import dimasicserver.item.AnotherBrickInTheWallItem;

import dimasicserver.DimasicServerMod;

public class DimasicServerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, DimasicServerMod.MODID);
	public static final DeferredItem<BlockItem> SABUDKA = ITEMS.registerSimpleBlockItem(DimasicServerModBlocks.SABUDKA);
	public static final DeferredItem<Item> MOON = block(DimasicServerModBlocks.MOON);
	public static final DeferredItem<Item> NAGARESPAWN = block(DimasicServerModBlocks.NAGARESPAWN);
	public static final DeferredItem<Item> LICHSPAWN = block(DimasicServerModBlocks.LICHSPAWN);
	public static final DeferredItem<Item> HYDRASPAWN = block(DimasicServerModBlocks.HYDRASPAWN);
	public static final DeferredItem<Item> UR_GHASTSPAWN = block(DimasicServerModBlocks.UR_GHASTSPAWN);
	public static final DeferredItem<Item> SNOWQUEENSPAWN = block(DimasicServerModBlocks.SNOWQUEENSPAWN);
	public static final DeferredHolder<Item, AnotherBrickInTheWallItem> ANOTHER_BRICK_IN_THE_WALL = REGISTRY.register("another_brick_in_the_wall", () -> new AnotherBrickInTheWallItem());

	private static DeferredItem<Item> block(DeferredHolder<Block, SabudkaBlock> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
