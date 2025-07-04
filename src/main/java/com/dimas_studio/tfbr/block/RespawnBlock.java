
package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
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

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState blockState, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		ItemInteractionResult result = super.useItemOn(stack, blockState, world, pos, entity, hand, hit);
		use(world, pos, entity);
		return result;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState blockState, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		InteractionResult result = super.useWithoutItem(blockState, world, pos, entity, hit);
		use(world, pos, entity);
		return result;
	}


	protected void use(Level world, BlockPos pos, Player entity) {
        return;
    }

}
