package dimasicserver.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;
import java.util.Iterator;

import dimasicserver.configuration.ConfigConfiguration;

public class SpawnlichProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double F = 0;
		BlockState central = Blocks.AIR.defaultBlockState();
		BlockState ring = Blocks.AIR.defaultBlockState();
		central = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ConfigConfiguration.LICH_TROPHY_BLOCK.get())).defaultBlockState();
		ring = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ConfigConfiguration.LICH_RING_BLOCK.get())).defaultBlockState();
		F = 0;
		if ((world.getBlockState(new BlockPos(x, y + 1, z))) == central) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x + 3, y, z))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x - 3, y, z))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x, y, z + 3))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x, y, z - 3))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x + 2, y, z + 2))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x + 2, y, z - 2))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x - 2, y, z + 2))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(new BlockPos(x - 2, y, z - 2))) == ring) {
			F = F + 1;
		}
		if (F == 9) {
			world.setBlock(new BlockPos(x, y, z), Blocks.BEDROCK.defaultBlockState(), 3);
			{
				BlockPos _bp = new BlockPos(x, y + 1, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x + 3, y, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x - 3, y, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x, y, z + 3);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x, y, z - 3);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x + 2, y, z + 2);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x + 2, y, z - 2);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x - 2, y, z - 2);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x - 2, y, z + 2);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (x + 3), y, z, 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (x - 3), y, z, 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, (z + 3), 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, (z - 3), 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (x + 2), y, (z + 2), 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (x + 2), y, (z - 2), 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (x - 2), y, (z + 2), 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (x - 2), y, (z - 2), 20, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 200, 0, 0, 0, 2);
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					{
						BlockPos _bp = new BlockPos(x, y + 1, z);
						BlockState _bs = Blocks.AIR.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
										_level.getServer(), null).withSuppressedOutput(),
								("setblock " + (new java.text.DecimalFormat("######## ").format(x) + ""
										+ (new java.text.DecimalFormat("######## ").format(y) + ""
												+ (new java.text.DecimalFormat("######## ").format(z) + "twilightforest:lich_boss_spawner")))));
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("dimasic_server:lichresp"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 40);
		} else {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 10, Explosion.BlockInteraction.DESTROY);
		}
	}
}
