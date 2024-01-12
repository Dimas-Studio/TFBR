
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import dimasicserver.block.UrGhastspawnBlock;
import dimasicserver.block.SnowqueenspawnBlock;
import dimasicserver.block.SabudkaBlock;
import dimasicserver.block.NagarespawnBlock;
import dimasicserver.block.MoonBlock;
import dimasicserver.block.LichspawnBlock;
import dimasicserver.block.HydraspawnBlock;

import dimasicserver.DimasicServerMod;

import static dimasicserver.DimasicServerMod.MODID;

public class DimasicServerModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, MODID);
	public static final DeferredHolder<Block, SabudkaBlock> SABUDKA = REGISTRY.register("sabudka", () -> new SabudkaBlock());
	public static final DeferredHolder<Block, MoonBlock> MOON = REGISTRY.register("moon", () -> new MoonBlock());
	public static final DeferredHolder<Block, NagarespawnBlock> NAGARESPAWN = REGISTRY.register("nagarespawn", () -> new NagarespawnBlock());
	public static final DeferredHolder<Block, LichspawnBlock> LICHSPAWN = REGISTRY.register("lichspawn", () -> new LichspawnBlock());
	public static final DeferredHolder<Block, HydraspawnBlock> HYDRASPAWN = REGISTRY.register("hydraspawn", () -> new HydraspawnBlock());
	public static final DeferredHolder<Block, UrGhastspawnBlock> UR_GHASTSPAWN = REGISTRY.register("ur_ghastspawn", () -> new UrGhastspawnBlock());
	public static final DeferredHolder<Block, SnowqueenspawnBlock> SNOWQUEENSPAWN = REGISTRY.register("snowqueenspawn", () -> new SnowqueenspawnBlock());
}
