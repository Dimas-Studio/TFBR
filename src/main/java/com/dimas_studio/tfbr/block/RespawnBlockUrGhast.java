package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.Config;
import com.dimas_studio.tfbr.utils.ReplaseBlock;
import com.dimas_studio.tfbr.utils.ReplaseBlock.ReplaseEffects;
import com.dimas_studio.tfbr.utils.Sound;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
import twilightforest.init.TFBlocks;

public class RespawnBlockUrGhast extends RespawnBlock{
    private static String MESSAGE_TRANSLATION_KEY = "message.ur_ghast.incorrect";

    public RespawnBlockUrGhast(Properties p_49795_) {
        super(p_49795_);
    }
    public void use(Level world, BlockPos pos, Player entity) {

        if(world.isClientSide()) {
            return;
        }

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        ReplaseBlock replaseBlock = new ReplaseBlock();

        ReplaseEffects replaceEffectsCentarl = replaseBlock.new ReplaseEffects(false, null, null);
        ReplaseEffects replaceEffectsRound = replaseBlock.new ReplaseEffects(true, null, null);
        ReplaseEffects replaceEffectsSpawner = replaseBlock.new ReplaseEffects(false, null,
                new Sound("entity.ghast.hurt", 3, 3, SoundSource.HOSTILE));
        ReplaseBlock.BlockToReplase[] blocksToReplace = {
                replaseBlock.new BlockToReplase(x,y+1,z, Blocks.AIR, replaceEffectsCentarl, 0),
                replaseBlock.new BlockToReplase(x+3,y,z, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 5),
                replaseBlock.new BlockToReplase(x,y,z+3, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 0),
                replaseBlock.new BlockToReplase(x-3,y,z, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 0),
                replaseBlock.new BlockToReplase(x,y,z-3, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 0),

                replaseBlock.new BlockToReplase(x+2,y,z+2, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 20),
                replaseBlock.new BlockToReplase(x-2,y,z+2, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 0),
                replaseBlock.new BlockToReplase(x-2,y,z-2, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 0),
                replaseBlock.new BlockToReplase(x+2,y,z-2, TFBlocks.ANTIBUILT_BLOCK.get(), replaceEffectsRound, 0),
                replaseBlock.new BlockToReplase(x, y, z, Blocks.AIR, replaceEffectsCentarl, 40),
                replaseBlock.new BlockToReplase(x,y+3,z, TFBlocks.UR_GHAST_BOSS_SPAWNER.get(), replaceEffectsSpawner, 0),
        };
        Block trophyBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.URGHAST_TROPHY_BLOCK.get()));
        Block materialBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(Config.URGHAST_RING_BLOCK.get()));

        if (!checkRespawnConditions(x,y,z,world, trophyBlock, materialBlock)) {
            Vector3f PARTICLE_COLOR_ROUND = Vec3.fromRGB24(16711680).toVector3f();
            DustParticleOptions PARTICLE_ROUND = new DustParticleOptions(PARTICLE_COLOR_ROUND, 1.0F);
            Vector3f PARTICLE_COLOR_CENTER = new Vec3(204,255,0).normalize().toVector3f();
            DustParticleOptions PARTICLE_CENTER = new DustParticleOptions(PARTICLE_COLOR_CENTER, 1.0F);
            incorrectAltar(x,y,z,world,entity,
                    trophyBlock,
                    materialBlock,
                    MESSAGE_TRANSLATION_KEY,
                    PARTICLE_CENTER,
                    PARTICLE_ROUND
            );
            return;
        }
        WorldBlockManagment.setBlock(x, y, z, world, Blocks.BEDROCK);

        WorldBlockManagment.setBlockAround(x, y, z, world, Blocks.BEDROCK, null);
        WorldBlockManagment.replaceBlocks(world, blocksToReplace);
        return;
    }

}
