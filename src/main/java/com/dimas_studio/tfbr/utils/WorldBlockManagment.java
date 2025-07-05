package com.dimas_studio.tfbr.utils;

import com.dimas_studio.tfbr.TFBR;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import twilightforest.block.TFChestBlock;

public class WorldBlockManagment {
    public static void setBlock(int x, int y, int z, Level world, Block block) {
        setBlock(BlockPos.containing(x, y, z), world, block);
    }
    public static void setBlock(BlockPos blockPos, Level world, Block block) {
        world.setBlock(blockPos, block.defaultBlockState(), 3);
    }

    public static boolean checkBlock(int x, int y, int z, Level world, Block block) {
        return getBlock(BlockPos.containing(x,y,z), world).equals(block);
    }

    public static Block getBlock(int x, int y, int z, Level world) {
        return getBlock(BlockPos.containing(x,y,z), world);
    }
    public static Block getBlock(BlockPos blockPos, Level world) {
        return world.getBlockState(blockPos).getBlock();
    }

    public static void setBlockAroundFiled(int x, int y, int z, int radius, Level world, Block block) {
        for (int x_block = x-radius; x_block<=x+radius; x_block++){
            for(int z_block = z-radius; z_block<=z+radius; z_block++){
                if (Math.abs(x_block-x)+Math.abs(z_block-z) <= radius) {
                    setBlock(x_block, y, z_block, world, block);
                }
            }
        }
    }

        public static void setBlockAround(int x, int y, int z, Level world, Block block, ReplaseBlock.ReplaseEffects replaseEffects) {
        setBlock(x+3, y, z, world, block);
        setBlock(x-3, y, z, world, block);
        setBlock(x, y, z+3, world, block);
        setBlock(x, y, z-3, world, block);
        setBlock(x+2, y, z+2, world, block);
        setBlock(x-2, y, z+2, world, block);
        setBlock(x+2, y, z-2, world, block);
        setBlock(x-2, y, z-2, world, block);

    }

    public static void replaceBlocks(Level world, ReplaseBlock.BlockToReplase[] blocksToReplase) {
        replaceBlocks(world, blocksToReplase, 0);
    }

    private static void replaceBlocks(Level world, ReplaseBlock.BlockToReplase[] blocksToReplase, int i) {
        if (i >= 0) {
             do {
                int x = blocksToReplase[i].x;
                int y = blocksToReplase[i].y;
                int z = blocksToReplase[i].z;
                Block block = blocksToReplase[i].block;
                WorldBlockManagment.setBlock(x, y, z, world, block);
                if (blocksToReplase[i].summonLightning) {
                    summonLighting(x, y, z, world);
                }
                if (blocksToReplase[i].sound != null) {
                    Sound sound = blocksToReplase[i].sound;
                    world.playSound(null, BlockPos.containing(x, y, z),sound.soundEvent, sound.soundSource, sound.level, sound.pitch);
                }
                i++;
                if (i == blocksToReplase.length){
                    return;
                }
            } while (blocksToReplase[i].tick == 0);
        }
        int finalI = i;
        TFBR.queueServerWork(blocksToReplase[i].tick, () -> replaceBlocks(world, blocksToReplase, finalI));
    }

    private static void summonLighting(int x, int y, int z, Level world) {
        LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(world);
        lightningBolt.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
        world.addFreshEntity(lightningBolt);
    }

    public static void summonBlock(Level world, BlockPos blockPos, Block block, int extraY) {
        if (world.getBlockState(blockPos).getBlock() instanceof TFChestBlock) {
            WorldBlockManagment.setBlock(BlockPos.containing(blockPos.getX(), blockPos.getY()+extraY, blockPos.getZ()), world, block);
            return;
        }
        TFBR.queueServerWork(40, () -> summonBlock(world, blockPos, block, extraY));
    }
}
