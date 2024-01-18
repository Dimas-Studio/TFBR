package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.Config;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import twilightforest.init.TFBlocks;

public class RespawnBlockHydra extends RespawnBlock{
    private static String MESSAGE_TRANSLATION_KEY = "message.hydra.incorrect";

    public RespawnBlockHydra(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {

        if(world.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        super.use(blockstate, world, pos, entity, hand, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        Block trophyBlock = BuiltInRegistries.BLOCK.get(new ResourceLocation(Config.HYDRA_TROPHY_BLOCK.get()));
        Block materialBlock = BuiltInRegistries.BLOCK.get(new ResourceLocation(Config.HYDRA_RING_BLOCK.get()));
        ReplaseBlock.ReplaseEffects replaseEffects = new ReplaseBlock.ReplaseEffects(false, null);
        ReplaseBlock.BlockToReplase[] blocksToReplase = {
                new ReplaseBlock.BlockToReplase(x,y+1,z, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x+3,y,z, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x+2,y,z+2, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x,y,z+3, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x-2,y,z+2, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x-3,y,z, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x-2,y,z-2, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x,y,z-3, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x+2,y,z-2, Blocks.AIR, replaseEffects, 0),
                new ReplaseBlock.BlockToReplase(x, y, z, Blocks.AIR, replaseEffects, 40),
                new ReplaseBlock.BlockToReplase(x,y+2,z, TFBlocks.HYDRA_BOSS_SPAWNER.get(), replaseEffects, 1),
        };

        if (!checkRespawnConditions(x,y,z,world, trophyBlock, materialBlock)) {
            incorrectAltar(x,y,z,world,entity,
                    trophyBlock,
                    materialBlock,
                    MESSAGE_TRANSLATION_KEY,
                    ParticleTypes.FLAME,
                    ParticleTypes.SMOKE
            );
            return InteractionResult.SUCCESS;
        }
        WorldBlockManagment.setBlock(x,y,z,world,Blocks.BEDROCK);
        WorldBlockManagment.replaceBlocks(world, blocksToReplase);
        if (world instanceof ServerLevel level)
            level.sendParticles(ParticleTypes.FLAME, x, y+1, z, 500, 1, 1, 1, 2);
        return InteractionResult.SUCCESS;
    }

}
