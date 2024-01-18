
package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;


public class RespawnBlock extends Block {
	public RespawnBlock(BlockBehaviour.Properties p_49795_) {
		super(p_49795_.noOcclusion());
	}



	protected void incorrectAltar(int x, int y, int z, Level world, Entity player, Block thophy, Block material, String tanslationkey, ParticleOptions centralParticle, ParticleOptions roundParticle) {
		if (player instanceof Player) {
			String message = String.format(Component.translatable(tanslationkey).getString(),
					material.getName().getString(),
					thophy.getName().getString()
			);
			player.sendSystemMessage(Component.literal(message));
		}
		if (world instanceof ServerLevel) {
			summonAllParticle(x,y,z,world,50, centralParticle, roundParticle);
		}
	}

	private void summonAllParticle(int x, int y, int z, Level world, int times, ParticleOptions centralParticle, ParticleOptions roundParticle) {
		summonParticle(x+3,y,z,world, roundParticle);
		summonParticle(x-3,y,z,world, roundParticle);
		summonParticle(x,y,z+3,world, roundParticle);
		summonParticle(x,y,z-3,world, roundParticle);
		summonParticle(x+2,y,z+2,world, roundParticle);
		summonParticle(x+2,y,z-2,world, roundParticle);
		summonParticle(x-2,y,z+2,world, roundParticle);
		summonParticle(x-2,y,z-2,world, roundParticle);
		summonParticle(x, y+1, z, world, centralParticle);
		if (times > 0) {
			TFBR.queueServerWork(5, () -> summonAllParticle(x,y,z,world,times-1, centralParticle, roundParticle));
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

	protected void replaceBlocksAround(Level world, ReplaseBlock.BlockToReplase[] blocksToReplase) {
		replaceBlocksAround(world, blocksToReplase, -1);
	}
	private void replaceBlocksAround(Level world, ReplaseBlock.BlockToReplase[] blocksToReplase, int i) {
		if (i >= 0) {
			int x = blocksToReplase[i].x;
			int y = blocksToReplase[i].y;
			int z = blocksToReplase[i].z;
			Block block = blocksToReplase[i].block;
			WorldBlockManagment.setBlock(x, y, z, world, block);
			if (blocksToReplase[i].summonLightning) {
				summonLighting(x, y, z, world);
			}
		}
		if (i+1 < blocksToReplase.length) {
			TFBR.queueServerWork(blocksToReplase[i+1].tick, () -> replaceBlocksAround(world, blocksToReplase, i+1));
		}
	}

	protected boolean checkRespawnConditions(int x, int y, int z,Level world, Block trophyBlock, Block materialBlock) {
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
