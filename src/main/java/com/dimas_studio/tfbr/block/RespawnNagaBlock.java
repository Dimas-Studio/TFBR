
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
import java.util.*;
import java.util.concurrent.TimeUnit;


public class RespawnNagaBlock extends Block {
	public RespawnNagaBlock(BlockBehaviour.Properties p_49795_) {
		super(p_49795_.noOcclusion());
	}

	private class BlockToReplase {
		private int x;
		private int y;
		private int z;
		private Block block;
		private boolean summonLightning;
		private int tick;

		private BlockToReplase (int x, int y, int z, Block block, boolean summonLightning, int tick) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.block = block;
			this.summonLightning = summonLightning;
			this.tick = tick;
		}
	}
	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {

		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		BlockToReplase[] blocksToReplase = {
				new BlockToReplase(x,y+1,z, Blocks.AIR, false, 1),
				new BlockToReplase(x+3,y,z, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x+2,y,z+2, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x,y,z+3, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x-2,y,z+2, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x-3,y,z, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x-2,y,z-2, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x,y,z-3, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x+2,y,z-2, Blocks.COAL_BLOCK, true, 20),
				new BlockToReplase(x,y,z, TFBlocks.NAGA_BOSS_SPAWNER.get(), false, 40),
		};

		Setblock.setBlockAround(x, y, z, world, Blocks.BEDROCK);
		replaceBlocksAround(world, blocksToReplase);
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

	private void replaceBlocksAround(Level world, BlockToReplase[] blocksToReplase) {
		replaceBlocksAround(world, blocksToReplase, -1);
	}
	private void replaceBlocksAround(Level world, BlockToReplase[] blocksToReplase, int i) {
		if (i >= 0) {
			int x = blocksToReplase[i].x;
			int y = blocksToReplase[i].y;
			int z = blocksToReplase[i].z;
			Block block = blocksToReplase[i].block;
			Setblock.setBlock(x, y, z, world, block);
			if (blocksToReplase[i].summonLightning) {
				summonLighting(x, y, z, world);
			}
		}
		if (i+1 < blocksToReplase.length) {
			TFBR.queueServerWork(blocksToReplase[i+1].tick, () -> replaceBlocksAround(world, blocksToReplase, i+1));
		}
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
