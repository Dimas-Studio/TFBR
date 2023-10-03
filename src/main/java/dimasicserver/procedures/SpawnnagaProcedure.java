package dimasicserver.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;
import java.util.Iterator;

import dimasicserver.configuration.ConfigConfiguration;

import dimasicserver.DimasicServerMod;

public class SpawnnagaProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency world for procedure Spawnnaga!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency x for procedure Spawnnaga!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency y for procedure Spawnnaga!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency z for procedure Spawnnaga!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency entity for procedure Spawnnaga!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double F = 0;
		BlockState central = Blocks.AIR.getDefaultState();
		BlockState ring = Blocks.AIR.getDefaultState();
		central = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ConfigConfiguration.NAGA_TROPHY_BLOCK.get())).getDefaultState();
		ring = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ConfigConfiguration.NAGA_RING_BLOCK.get())).getDefaultState();
		F = 0;
		if ((world.getBlockState(new BlockPos(x, y + 1, z))) == (central)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x + 3, y, z))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x - 3, y, z))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x, y, z + 3))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x, y, z - 3))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x + 2, y, z + 2))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x + 2, y, z - 2))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x - 2, y, z + 2))) == (ring)) {
			F = (F + 1);
		}
		if ((world.getBlockState(new BlockPos(x - 2, y, z - 2))) == (ring)) {
			F = (F + 1);
		}
		if (F == 9) {
			world.setBlockState(new BlockPos(x, y, z), Blocks.BEDROCK.getDefaultState(), 3);
			{
				BlockPos _bp = new BlockPos(x, y + 1, z);
				BlockState _bs = Blocks.OAK_LEAVES.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x + 3, y, z);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x - 3, y, z);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x, y, z + 3);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x, y, z - 3);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x + 2, y, z + 2);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x + 2, y, z - 2);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x - 2, y, z + 2);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos(x - 2, y, z - 2);
				BlockState _bs = Blocks.BEDROCK.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
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
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x + 3, y, z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					{
						BlockPos _bp = new BlockPos(x + 3, y, z);
						BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
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
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x - 3, y, z)));
								_ent.setEffectOnly(false);
								((World) world).addEntity(_ent);
							}
							{
								BlockPos _bp = new BlockPos(x - 3, y, z);
								BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlockState(_bp, _bs, 3);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
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
									if (world instanceof ServerWorld) {
										LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
										_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x, y, z + 3)));
										_ent.setEffectOnly(false);
										((World) world).addEntity(_ent);
									}
									{
										BlockPos _bp = new BlockPos(x, y, z + 3);
										BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										world.setBlockState(_bp, _bs, 3);
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;

										public void start(IWorld world, int waitTicks) {
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
											if (world instanceof ServerWorld) {
												LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
												_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x, y, z - 3)));
												_ent.setEffectOnly(false);
												((World) world).addEntity(_ent);
											}
											{
												BlockPos _bp = new BlockPos(x, y, z - 3);
												BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												world.setBlockState(_bp, _bs, 3);
											}
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private IWorld world;

												public void start(IWorld world, int waitTicks) {
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
													if (world instanceof ServerWorld) {
														LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
														_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x + 2, y, z + 2)));
														_ent.setEffectOnly(false);
														((World) world).addEntity(_ent);
													}
													{
														BlockPos _bp = new BlockPos(x + 2, y, z + 2);
														BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															Property _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_property != null && _bs.get(_property) != null)
																try {
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
																} catch (Exception e) {
																}
														}
														world.setBlockState(_bp, _bs, 3);
													}
													new Object() {
														private int ticks = 0;
														private float waitTicks;
														private IWorld world;

														public void start(IWorld world, int waitTicks) {
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
															if (world instanceof ServerWorld) {
																LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
																_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x + 2, y, z - 2)));
																_ent.setEffectOnly(false);
																((World) world).addEntity(_ent);
															}
															{
																BlockPos _bp = new BlockPos(x + 2, y, z - 2);
																BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	Property _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_property != null && _bs.get(_property) != null)
																		try {
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																		} catch (Exception e) {
																		}
																}
																world.setBlockState(_bp, _bs, 3);
															}
															new Object() {
																private int ticks = 0;
																private float waitTicks;
																private IWorld world;

																public void start(IWorld world, int waitTicks) {
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
																	if (world instanceof ServerWorld) {
																		LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
																		_ent.moveForced(
																				Vector3d.copyCenteredHorizontally(new BlockPos(x - 2, y, z + 2)));
																		_ent.setEffectOnly(false);
																		((World) world).addEntity(_ent);
																	}
																	{
																		BlockPos _bp = new BlockPos(x - 2, y, z + 2);
																		BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			Property _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_property != null && _bs.get(_property) != null)
																				try {
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																				} catch (Exception e) {
																				}
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																	new Object() {
																		private int ticks = 0;
																		private float waitTicks;
																		private IWorld world;

																		public void start(IWorld world, int waitTicks) {
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
																			if (world instanceof ServerWorld) {
																				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT
																						.create((World) world);
																				_ent.moveForced(Vector3d
																						.copyCenteredHorizontally(new BlockPos(x - 2, y, z - 2)));
																				_ent.setEffectOnly(false);
																				((World) world).addEntity(_ent);
																			}
																			{
																				BlockPos _bp = new BlockPos(x - 2, y, z - 2);
																				BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					Property _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_property != null && _bs.get(_property) != null)
																						try {
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																						} catch (Exception e) {
																						}
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																			new Object() {
																				private int ticks = 0;
																				private float waitTicks;
																				private IWorld world;

																				public void start(IWorld world, int waitTicks) {
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
																						BlockState _bs = Blocks.AIR.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							Property _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_property != null && _bs.get(_property) != null)
																								try {
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																								} catch (Exception e) {
																								}
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																					if (world instanceof ServerWorld) {
																						((World) world).getServer().getCommandManager()
																								.handleCommand(new CommandSource(ICommandSource.DUMMY,
																										new Vector3d(x, y, z), Vector2f.ZERO,
																										(ServerWorld) world, 4, "",
																										new StringTextComponent(""),
																										((World) world).getServer(), null)
																										.withFeedbackDisabled(),
																										("setblock " + (new java.text.DecimalFormat(
																												"######## ").format(x)
																												+ ""
																												+ (new java.text.DecimalFormat(
																														"######## ").format(y)
																														+ ""
																														+ (new java.text.DecimalFormat(
																																"######## ").format(z)
																																+ "twilightforest:boss_spawner_naga")))));
																					}
																					if (entity instanceof ServerPlayerEntity) {
																						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																								.getAdvancementManager()
																								.getAdvancement(new ResourceLocation(
																										"dimasic_server:nagaresp"));
																						AdvancementProgress _ap = ((ServerPlayerEntity) entity)
																								.getAdvancements().getProgress(_adv);
																						if (!_ap.isDone()) {
																							Iterator _iterator = _ap.getRemaningCriteria().iterator();
																							while (_iterator.hasNext()) {
																								String _criterion = (String) _iterator.next();
																								((ServerPlayerEntity) entity).getAdvancements()
																										.grantCriterion(_adv, _criterion);
																							}
																						}
																					}
																					MinecraftForge.EVENT_BUS.unregister(this);
																				}
																			}.start(world, (int) 40);
																			MinecraftForge.EVENT_BUS.unregister(this);
																		}
																	}.start(world, (int) 20);
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 20);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 20);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 20);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.DESTROY);
			}
		}
	}
}
