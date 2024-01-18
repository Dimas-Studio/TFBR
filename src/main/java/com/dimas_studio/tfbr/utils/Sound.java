package com.dimas_studio.tfbr.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class Sound {
    public SoundEvent soundEvent;
    public int level;
    public int pitch;
    public SoundSource soundSource;

    public Sound(String resourceLocation, int level, int pitch, SoundSource soundSource) {
        this.soundEvent = BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation(resourceLocation));
        this.level = level;
        this.pitch = pitch;
        this.soundSource = soundSource;
    }
}
