
package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import twilightforest.init.TFBlocks;


public class RespawnNagaBlock extends Block {
	public RespawnNagaBlock(BlockBehaviour.Properties p_49795_) {
		super(p_49795_.noOcclusion());
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		if (!checkRespawnConditions(x,y,z,world,TFBlocks.NAGA_TROPHY.get(), Blocks.IRON_BLOCK)) {
			incorrectAltar(x,y,z,world,entity);
			return InteractionResult.SUCCESS;
		}

		WorldBlockManagment.setBlock(x, y+1, z, world, Blocks.AIR);
		WorldBlockManagment.setBlockAround(x, y, z, world, Blocks.BEDROCK);
		replaceBlocksAround(x, y, z, world, Blocks.COAL_BLOCK);
		return InteractionResult.SUCCESS;
	}

	private void incorrectAltar(int x, int y, int z, Level world, Entity player) {
		if (player instanceof Player) {
			player.sendSystemMessage(Component.translatable("message.naga.incorrect").append(" ").append(Blocks.IRON_BLOCK.getName()));
		}
		if (world instanceof ServerLevel) {
			summonAllParticle(x,y,z,world,50);
		}
	}

	private void summonAllParticle(int x, int y, int z, Level world, int times) {
		summonParticle(x+3,y,z,world, ParticleTypes.CRIT);
		summonParticle(x-3,y,z,world, ParticleTypes.CRIT);
		summonParticle(x,y,z+3,world, ParticleTypes.CRIT);
		summonParticle(x,y,z-3,world, ParticleTypes.CRIT);
		summonParticle(x+2,y,z+2,world, ParticleTypes.CRIT);
		summonParticle(x+2,y,z-2,world, ParticleTypes.CRIT);
		summonParticle(x-2,y,z+2,world, ParticleTypes.CRIT);
		summonParticle(x-2,y,z-2,world, ParticleTypes.CRIT);
		summonParticle(x, y+1, z, world, ParticleTypes.HAPPY_VILLAGER);
		if (times > 0) {
			TFBR.queueServerWork(5, () -> summonAllParticle(x,y,z,world,times-1));
		}
	}

	private void summonParticle(int X, int Y, int Z, Level world, ParticleOptions particleOptions){
			RandomSource random = world.random;
			double x = X + 0.5;
			double y = Y + 0.5;
			double z = Z + 0.5;
			for (int i = 0; i < 1 + random.nextInt(5); i++) {
				double particleX = x - 0.2 + random.nextDouble() * 0.4;
				double particleY = y - 0.2 + random.nextDouble() * 0.4;
				double particleZ = z - 0.2 + random.nextDouble() * 0.4;

				Minecraft.getInstance().levelRenderer.addParticle(
						particleOptions, false,
						particleX, particleY, particleZ, 0, 0, 0);
		}
	}

	private void summonLighting(int x, int y, int z, Level world) {
		LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(world);
		lightningBolt.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
		world.addFreshEntity(lightningBolt);
	}

	private void replaceBlocksAround(int x, int y, int z, Level world, Block block) {
        //TODO: РЕКУРСИЯ!
		TFBR.queueServerWork(20, () -> {
			WorldBlockManagment.setBlock(x+3, y, z, world, block);
			summonLighting(x+3, y, z, world);

			TFBR.queueServerWork(20, () -> {
				WorldBlockManagment.setBlock(x+2, y, z+2, world, block);
				summonLighting(x+2, y, z+2, world);

				TFBR.queueServerWork(20, () -> {
					WorldBlockManagment.setBlock(x, y, z+3, world, block);
					summonLighting(x, y, z+3, world);

					TFBR.queueServerWork(20, () -> {
						WorldBlockManagment.setBlock(x-2, y, z+2, world, block);
						summonLighting(x-2, y, z+2, world);

						TFBR.queueServerWork(20, () -> {
							WorldBlockManagment.setBlock(x-3, y, z, world, block);
							summonLighting(x-3, y, z, world);

							TFBR.queueServerWork(20, () -> {
								WorldBlockManagment.setBlock(x-2, y, z-2, world, block);
								summonLighting(x-2, y, z-2, world);

								TFBR.queueServerWork(20, () -> {
									WorldBlockManagment.setBlock(x, y, z-3, world, block);
									summonLighting(x, y, z-3, world);

									TFBR.queueServerWork(20, () -> {
										WorldBlockManagment.setBlock(x+2, y, z-2, world, block);
										summonLighting(x+2, y, z-2, world);

										TFBR.queueServerWork(20, () -> {
											WorldBlockManagment.setBlock(x, y, z, world, Blocks.AIR);
											WorldBlockManagment.setBlock(x, y+2, z, world, TFBlocks.NAGA_BOSS_SPAWNER.get());
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}

	private boolean checkRespawnConditions(int x, int y, int z,Level world, Block trophyBlock, Block materialBlock) {
		if (!WorldBlockManagment.checkBlock(x, y+1, z, world, trophyBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x+3, y, z, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x-3, y, z, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x, y, z+3, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x, y, z-3, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x+2, y, z+2, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x+2, y, z-2, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x-2, y, z+2, world, materialBlock)) {
			return false;
		}
		if (!WorldBlockManagment.checkBlock(x-2, y, z-2, world, materialBlock)) {
			return false;
		}
		return true;
	}

}
