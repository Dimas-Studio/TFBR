package com.dimas_studio.tfbr.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

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

    public static void setBlockAround(int x, int y, int z, Level world, Block block) {
        setBlock(x+3, y, z, world, block);
        setBlock(x-3, y, z, world, block);
        setBlock(x, y, z+3, world, block);
        setBlock(x, y, z-3, world, block);
        setBlock(x+2, y, z+2, world, block);
        setBlock(x-2, y, z+2, world, block);
        setBlock(x+2, y, z-2, world, block);
        setBlock(x-2, y, z-2, world, block);
    }


}
