package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.Config;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import twilightforest.init.TFBlocks;

public class RespawnBlockLich extends RespawnBlock{
    private static String MESSAGE_TRANSLATION_KEY = "message.lich.incorrect";

    public RespawnBlockLich(Properties p_49795_) {
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

        Block trophyBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.LICH_TROPHY_BLOCK.get()));
        Block materialBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.LICH_RING_BLOCK.get()));

        ReplaseBlock replaseBlock = new ReplaseBlock();
        ReplaseBlock.ReplaseEffects replaseEffects = replaseBlock.new ReplaseEffects(false, null, null);
        ReplaseBlock.BlockToReplase[] blocksToReplase = {
                replaseBlock.new BlockToReplase(x,y+1,z, Blocks.AIR, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x+3,y,z, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x+2,y,z+2, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x,y,z+3, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x-2,y,z+2, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x-3,y,z, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x-2,y,z-2, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x,y,z-3, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x+2,y,z-2, Blocks.GLASS, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x, y, z, Blocks.GLASS, replaseEffects, 40),
                replaseBlock.new BlockToReplase(x,y+2,z, TFBlocks.LICH_BOSS_SPAWNER.get(), replaseEffects, 1),
        };

        if (!checkRespawnConditions(x,y,z,world, trophyBlock, materialBlock)) {
            incorrectAltar(x,y,z,world,entity,
                    trophyBlock,
                    materialBlock,
                    MESSAGE_TRANSLATION_KEY,
                    ParticleTypes.REVERSE_PORTAL,
                    ParticleTypes.FLAME
            );
            return;
        }
        WorldBlockManagment.setBlock(x,y,z,world,Blocks.BARRIER);
        WorldBlockManagment.replaceBlocks(world, blocksToReplase);
        if (world instanceof ServerLevel level)
            level.sendParticles(ParticleTypes.PORTAL, x, y+1, z, 500, 1, 1, 1, 2);
        return;
    }

}
