package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.Config;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import twilightforest.init.TFBlocks;

public class RespawnBlockNaga extends RespawnBlock{
    private static String MESSAGE_TRANSLATION_KEY = "message.naga.incorrect";

    public RespawnBlockNaga(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public void use(Level world, BlockPos pos, Player entity) {

        if(world.isClientSide()) {
            return;
        }

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        ReplaseBlock replaseBlock = new ReplaseBlock();
        ReplaseBlock.ReplaseEffects replaseEffectsCentarl = replaseBlock.new ReplaseEffects(false, null, null);
        ReplaseBlock.ReplaseEffects replaseEffectsRound = replaseBlock.new ReplaseEffects(true, null, null);
        ReplaseBlock.BlockToReplase[] blocksToReplase = {
                replaseBlock.new BlockToReplase(x,y+1,z, Blocks.AIR, replaseEffectsCentarl, 1),
                replaseBlock.new BlockToReplase(x+3,y,z, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x+2,y,z+2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x,y,z+3, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x-2,y,z+2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x-3,y,z, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x-2,y,z-2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x,y,z-3, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x+2,y,z-2, Blocks.COAL_BLOCK, replaseEffectsRound, 20),
                replaseBlock.new BlockToReplase(x, y, z, Blocks.AIR, replaseEffectsCentarl, 40),
                replaseBlock.new BlockToReplase(x,y+2,z, TFBlocks.NAGA_BOSS_SPAWNER.get(), replaseEffectsCentarl, 1),
        };
        Block trophyBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.NAGA_TROPHY_BLOCK.get()));
        Block materialBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.NAGA_RING_BLOCK.get()));

        if (!checkRespawnConditions(x,y,z,world, trophyBlock, materialBlock)) {
            incorrectAltar(x,y,z,world,entity,
                    trophyBlock,
                    materialBlock,
                    MESSAGE_TRANSLATION_KEY,
                    ParticleTypes.HAPPY_VILLAGER,
                    ParticleTypes.CRIT
            );
            return;
        }
        WorldBlockManagment.setBlockAround(x, y, z, world, Blocks.BEDROCK, null);
        WorldBlockManagment.replaceBlocks(world, blocksToReplase);
        return;
    }

}
