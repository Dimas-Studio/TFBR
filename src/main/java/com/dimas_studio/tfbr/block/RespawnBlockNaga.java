package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.Config;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import twilightforest.init.TFBlocks;

public class RespawnBlockNaga extends RespawnBlock{
    private static String MESSAGE_TRANSLATION_KEY = "message.naga.incorrect";

    public RespawnBlockNaga(Properties p_49795_) {
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
        ReplaseBlock.ReplaseEffects replaseEffectsCentarl = new ReplaseBlock.ReplaseEffects(false, null);
        ReplaseBlock.ReplaseEffects replaseEffectsRound = new ReplaseBlock.ReplaseEffects(true, null);
        ReplaseBlock.BlockToReplase[] blocksToReplase = {
                new ReplaseBlock.BlockToReplase(x,y+1,z, Blocks.AIR, replaseEffectsCentarl, 1),
                new ReplaseBlock.BlockToReplase(x+3,y,z, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x+2,y,z+2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x,y,z+3, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x-2,y,z+2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x-3,y,z, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x-2,y,z-2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x,y,z-3, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x+2,y,z-2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                new ReplaseBlock.BlockToReplase(x, y, z, Blocks.AIR, replaseEffectsCentarl, 40),
                new ReplaseBlock.BlockToReplase(x,y+2,z, TFBlocks.NAGA_BOSS_SPAWNER.get(), replaseEffectsCentarl, 1),
        };
        Block trophyBlock = BuiltInRegistries.BLOCK.get(new ResourceLocation(Config.NAGA_TROPHY_BLOCK.get()));
        Block materialBlock = BuiltInRegistries.BLOCK.get(new ResourceLocation(Config.NAGA_RING_BLOCK.get()));

        if (!checkRespawnConditions(x,y,z,world, trophyBlock, materialBlock)) {
            incorrectAltar(x,y,z,world,entity,
                    trophyBlock,
                    materialBlock,
                    MESSAGE_TRANSLATION_KEY,
                    ParticleTypes.HAPPY_VILLAGER,
                    ParticleTypes.CRIT
            );
            return InteractionResult.SUCCESS;
        }
        WorldBlockManagment.setBlockAround(x, y, z, world, Blocks.BEDROCK, null);
        WorldBlockManagment.replaceBlocks(world, blocksToReplase);
        return InteractionResult.SUCCESS;
    }

}
