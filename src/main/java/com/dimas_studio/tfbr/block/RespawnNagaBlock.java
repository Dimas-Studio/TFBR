
package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.utils.Setblock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
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

		return InteractionResult.SUCCESS;
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
}
