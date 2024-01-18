package com.dimas_studio.tfbr.utils;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.block.Block;

public class ReplaseBlock {
    public static class BlockToReplase {
        public int x;
        public int y;
        public int z;
        public Block block;
        public boolean summonLightning;
        public ParticleOptions particleToCenter;

        public int tick;

        public BlockToReplase(int x, int y, int z, Block block, ReplaseEffects replaseEffects, int tick) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.block = block;
            this.summonLightning = replaseEffects.summonLightning;
            this.tick = tick;
            if (replaseEffects.particleToCenter != null) {
                this.particleToCenter = ReplaseEffects.particleToCenter;
            }
        }
    }

    public static class ReplaseEffects {
        public boolean summonLightning;
        public static ParticleOptions particleToCenter;
        public ReplaseEffects(boolean summonLightning, ParticleOptions particleToCenter) {
            this.summonLightning = summonLightning;
            if (particleToCenter != null) {
                this.particleToCenter = particleToCenter;
            } else {
                this.particleToCenter = null;
            }
        }
    }
}
