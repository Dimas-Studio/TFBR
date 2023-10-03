
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dimasicserver.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import dimasicserver.DimasicServerMod;

public class DimasicServerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DimasicServerMod.MODID);
	public static final RegistryObject<SoundEvent> ANOTHER_BRICK_IN_THE_WALL = REGISTRY.register("another_brick_in_the_wall", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("dimasic_server", "another_brick_in_the_wall")));
}
