
package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.utils.Setblock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
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
import org.jetbrains.annotations.Nullable;
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

		Setblock.setBlock(x, y+1, z, world, Blocks.OAK_LEAVES);
		Setblock.setBlockAround(x, y, z, world, Blocks.BEDROCK);
		replaceBlocksAround(x, y, z, world, Blocks.COAL_BLOCK);
		Setblock.setBlock(x, y+1, z, world, Blocks.OAK_LEAVES);

		return InteractionResult.SUCCESS;
	}

	private void summonLighting(int x, int y, int z, Level world) {
		LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(world);
		lightningBolt.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
		world.addFreshEntity(lightningBolt);
	}

	private void replaceBlocksAround(int x, int y, int z, Level world, Block block) {
        //TODO: РЕКУРСИЯ!
		TFBR.queueServerWork(20, () -> {
			Setblock.setBlock(x+3, y, z, world, block);
			summonLighting(x+3, y, z, world);

			TFBR.queueServerWork(20, () -> {
				Setblock.setBlock(x+2, y, z+2, world, block);
				summonLighting(x+2, y, z+2, world);

				TFBR.queueServerWork(20, () -> {
					Setblock.setBlock(x, y, z+3, world, block);
					summonLighting(x, y, z+3, world);

					TFBR.queueServerWork(20, () -> {
						Setblock.setBlock(x-2, y, z+2, world, block);
						summonLighting(x-2, y, z+2, world);

						TFBR.queueServerWork(20, () -> {
							Setblock.setBlock(x-3, y, z, world, block);
							summonLighting(x-3, y, z, world);

							TFBR.queueServerWork(20, () -> {
								Setblock.setBlock(x-2, y, z-2, world, block);
								summonLighting(x-2, y, z-2, world);

								TFBR.queueServerWork(20, () -> {
									Setblock.setBlock(x, y, z-3, world, block);
									summonLighting(x, y, z-3, world);

									TFBR.queueServerWork(20, () -> {
										Setblock.setBlock(x+2, y, z-2, world, block);
										summonLighting(x+2, y, z-2, world);

										TFBR.queueServerWork(20, () -> {
											Setblock.setBlock(x, y, z, world, Blocks.AIR);
											Setblock.setBlock(x, y+2, z, world, TFBlocks.NAGA_BOSS_SPAWNER.get());
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
}
