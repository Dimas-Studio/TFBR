package dimasicserver.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;

import dimasicserver.configuration.ConfigConfiguration;

import dimasicserver.DimasicServerMod;

public class SpawnnagaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double F = 0;
		BlockState central = Blocks.AIR.defaultBlockState();
		BlockState ring = Blocks.AIR.defaultBlockState();
		central = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ConfigConfiguration.NAGA_TROPHY_BLOCK.get())).defaultBlockState();
		ring = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ConfigConfiguration.NAGA_RING_BLOCK.get())).defaultBlockState();
		F = 0;
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))) == central) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 3, y, z))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 3, y, z))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 3))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z - 3))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 2, y, z + 2))) == ring) {
			F = F + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 2, y, z - 2))) == ring) {
			F = F + 1;
		}
		if (F == 9) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.BEDROCK.defaultBlockState(), 3);
			{
				BlockPos _bp = BlockPos.containing(x, y + 1, z);
				BlockState _bs = Blocks.OAK_LEAVES.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x + 3, y, z);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x - 3, y, z);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x, y, z + 3);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x, y, z - 3);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x + 2, y, z + 2);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x + 2, y, z - 2);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x - 2, y, z + 2);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
				BlockPos _bp = BlockPos.containing(x - 2, y, z - 2);
				BlockState _bs = Blocks.BEDROCK.defaultBlockState();
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
			DimasicServerMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 3, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
				{
					BlockPos _bp = BlockPos.containing(x + 3, y, z);
					BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
				DimasicServerMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 3, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
					{
						BlockPos _bp = BlockPos.containing(x - 3, y, z);
						BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
					DimasicServerMod.queueServerWork(20, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z + 3)));;
							_level.addFreshEntity(entityToSpawn);
						}
						{
							BlockPos _bp = BlockPos.containing(x, y, z + 3);
							BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
						DimasicServerMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z - 3)));;
								_level.addFreshEntity(entityToSpawn);
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z - 3);
								BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
							DimasicServerMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 2, y, z + 2)));;
									_level.addFreshEntity(entityToSpawn);
								}
								{
									BlockPos _bp = BlockPos.containing(x + 2, y, z + 2);
									BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
								DimasicServerMod.queueServerWork(20, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 2, y, z - 2)));;
										_level.addFreshEntity(entityToSpawn);
									}
									{
										BlockPos _bp = BlockPos.containing(x + 2, y, z - 2);
										BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
									DimasicServerMod.queueServerWork(20, () -> {
										if (world instanceof ServerLevel _level) {
											LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
											entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 2, y, z + 2)));;
											_level.addFreshEntity(entityToSpawn);
										}
										{
											BlockPos _bp = BlockPos.containing(x - 2, y, z + 2);
											BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
										DimasicServerMod.queueServerWork(20, () -> {
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x - 2, y, z - 2)));;
												_level.addFreshEntity(entityToSpawn);
											}
											{
												BlockPos _bp = BlockPos.containing(x - 2, y, z - 2);
												BlockState _bs = Blocks.COAL_BLOCK.defaultBlockState();
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
											DimasicServerMod.queueServerWork(40, () -> {
												{
													BlockPos _bp = BlockPos.containing(x, y + 1, z);
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
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															("setblock " + (new java.text.DecimalFormat("######## ").format(x) + ""
																	+ (new java.text.DecimalFormat("######## ").format(y) + "" + (new java.text.DecimalFormat("######## ").format(z) + "twilightforest:boss_spawner_naga")))));
												if (entity instanceof ServerPlayer _player) {
													Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("dimasic_server:nagaresp"));
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											});
										});
									});
								});
							});
						});
					});
				});
			});
		} else {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 10, Level.ExplosionInteraction.BLOCK);
		}
	}
}
