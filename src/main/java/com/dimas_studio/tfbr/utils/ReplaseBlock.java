package com.dimas_studio.tfbr.utils;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.block.Block;


public class ReplaseBlock {
    public class BlockToReplase {
        public int x;
        public int y;
        public int z;
        public Block block;
        public boolean summonLightning;
        public ParticleOptions particleToCenter;
        public Sound sound;

        public int tick;

        public BlockToReplase(int x, int y, int z, Block block, ReplaseEffects replaseEffects, int tick) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.block = block;
            this.summonLightning = replaseEffects.summonLightning;
            this.tick = tick;
            this.particleToCenter = replaseEffects.particleToCenter;
            this.sound = replaseEffects.sound;
        }
    }

    public class ReplaseEffects {
        public boolean summonLightning;
        public ParticleOptions particleToCenter;
        public Sound sound;
        public ReplaseEffects(boolean summonLightning, ParticleOptions particleToCenter, Sound sound) {
            this.summonLightning = summonLightning;
            this.particleToCenter = particleToCenter;
            this.sound = sound;
        }
    }
}
