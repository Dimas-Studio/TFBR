package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.Config;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
import twilightforest.init.TFBlocks;

public class RespawnBlockSnowQueen extends RespawnBlock{
    private static String MESSAGE_TRANSLATION_KEY = "message.snow_queen.incorrect";

    public RespawnBlockSnowQueen(Properties p_49795_) {
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

        Block trophyBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.SQ_TROPHY_BLOCK.get()));
        Block materialBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.SQ_RING_BLOCK.get()));

        ReplaseBlock replaseBlock = new ReplaseBlock();
        ReplaseBlock.ReplaseEffects replaseEffects = replaseBlock.new ReplaseEffects(false, null, null);
        ReplaseBlock.BlockToReplase[] blocksToReplase = {
                replaseBlock.new BlockToReplase(x,y+1,z, Blocks.AIR, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x+3,y,z, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x+2,y,z+2, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x,y,z+3, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x-2,y,z+2, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x-3,y,z, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x-2,y,z-2, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x,y,z-3, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x+2,y,z-2, Blocks.SNOW, replaseEffects, 0),
                replaseBlock.new BlockToReplase(x, y, z, Blocks.SNOW, replaseEffects, 40),
                replaseBlock.new BlockToReplase(x,y+3,z, TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get(), replaseEffects, 1),
        };

        if (!checkRespawnConditions(x,y,z,world, trophyBlock, materialBlock)) {
            Vector3f PARTICLE_COLOR = new Vec3(100,200,255).normalize().toVector3f();
            DustParticleOptions PARTICLE = new DustParticleOptions(PARTICLE_COLOR, 1.0F);
            incorrectAltar(x,y,z,world,entity,
                    trophyBlock,
                    materialBlock,
                    MESSAGE_TRANSLATION_KEY,
                    PARTICLE,
                    ParticleTypes.SNOWFLAKE
            );
            return;
        }
        WorldBlockManagment.setBlock(x,y,z,world,Blocks.BARRIER);
        WorldBlockManagment.replaceBlocks(world, blocksToReplase);
        if (world instanceof ServerLevel level) {
            Vector3f PARTICLE_COLOR = new Vec3(255,255,255).normalize().toVector3f();
            DustParticleOptions PARTICLE = new DustParticleOptions(PARTICLE_COLOR, 1.0F);
            level.sendParticles(PARTICLE, x, y + 3, z, 500, 1, 1, 1, 2);
        }
        return;
    }

}
