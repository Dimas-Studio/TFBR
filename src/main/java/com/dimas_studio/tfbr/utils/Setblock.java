package com.dimas_studio.tfbr.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Setblock {
    public static void setBlock(int x, int y, int z, Level world, Block block) {
        world.setBlock(BlockPos.containing(x, y, z), block.defaultBlockState(), 3);
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
