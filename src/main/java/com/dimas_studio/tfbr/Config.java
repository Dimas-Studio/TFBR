package com.dimas_studio.tfbr;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = TFBR.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<String> NAGA_TROPHY_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> NAGA_RING_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> LICH_TROPHY_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> LICH_RING_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRA_TROPHY_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRA_RING_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> URGHAST_TROPHY_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> URGHAST_RING_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> SQ_TROPHY_BLOCK;
    public static final ForgeConfigSpec.ConfigValue<String> SQ_RING_BLOCK;

    static {
        BUILDER.push("Naga resurrection");
        NAGA_TROPHY_BLOCK = BUILDER.define("naga_trophy_block", "twilightforest:naga_trophy");
        NAGA_RING_BLOCK = BUILDER.define("naga_ring_block", "twilightforest:ironwood_block");
        BUILDER.pop();

        BUILDER.push("Lich resurrection");
        LICH_TROPHY_BLOCK = BUILDER.define("lich_trophy_block", "twilightforest:lich_trophy");
        LICH_RING_BLOCK = BUILDER.define("lich_ring_block", "minecraft:gold_block");
        BUILDER.pop();

        BUILDER.push("Hydra resurrection");
        HYDRA_TROPHY_BLOCK = BUILDER.define("hydra_trophy_block", "twilightforest:hydra_trophy");
        HYDRA_RING_BLOCK = BUILDER.define("hydra_ring_block", "minecraft:ancient_debris");
        BUILDER.pop();

        BUILDER.push("Ur-Ghast resurrection");
        URGHAST_TROPHY_BLOCK = BUILDER.define("urghast_trophy_block", "twilightforest:ur_ghast_trophy");
        URGHAST_RING_BLOCK = BUILDER.define("urghast_ring_block", "twilightforest:knightmetal_block");
        BUILDER.pop();

        BUILDER.push("Snow Queen resurrection");
        SQ_TROPHY_BLOCK = BUILDER.define("sq_trophy_block", "twilightforest:snow_queen_trophy");
        SQ_RING_BLOCK = BUILDER.define("sq_ring_block", "twilightforest:arctic_fur_block");
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

    }
}
