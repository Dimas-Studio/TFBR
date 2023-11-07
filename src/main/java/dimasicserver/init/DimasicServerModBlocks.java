
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import dimasicserver.block.UrGhastspawnBlock;
import dimasicserver.block.SnowqueenspawnBlock;
import dimasicserver.block.SabudkaBlock;
import dimasicserver.block.NagarespawnBlock;
import dimasicserver.block.MoonBlock;
import dimasicserver.block.LichspawnBlock;
import dimasicserver.block.HydraspawnBlock;

import dimasicserver.DimasicServerMod;

public class DimasicServerModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DimasicServerMod.MODID);
	public static final RegistryObject<Block> SABUDKA = REGISTRY.register("sabudka", () -> new SabudkaBlock());
	public static final RegistryObject<Block> MOON = REGISTRY.register("moon", () -> new MoonBlock());
	public static final RegistryObject<Block> NAGARESPAWN = REGISTRY.register("nagarespawn", () -> new NagarespawnBlock());
	public static final RegistryObject<Block> LICHSPAWN = REGISTRY.register("lichspawn", () -> new LichspawnBlock());
	public static final RegistryObject<Block> HYDRASPAWN = REGISTRY.register("hydraspawn", () -> new HydraspawnBlock());
	public static final RegistryObject<Block> UR_GHASTSPAWN = REGISTRY.register("ur_ghastspawn", () -> new UrGhastspawnBlock());
	public static final RegistryObject<Block> SNOWQUEENSPAWN = REGISTRY.register("snowqueenspawn", () -> new SnowqueenspawnBlock());
}
