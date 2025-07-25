package dimasicserver.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<String> NAGA_TROPHY_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> NAGA_RING_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> NAGA_ENTITY;
	public static final ForgeConfigSpec.ConfigValue<String> LICH_TROPHY_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> LICH_RING_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> LICH_ENTITY;
	public static final ForgeConfigSpec.ConfigValue<String> HYDRA_TROPHY_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> HYDRA_RING_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> HYDRA_ENTITY;
	public static final ForgeConfigSpec.ConfigValue<String> URGHAST_TROPHY_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> URGHAST_RING_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> URGHAST_ENTITY;
	public static final ForgeConfigSpec.ConfigValue<String> SQ_TROPHY_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> SQ_RING_BLOCK;
	public static final ForgeConfigSpec.ConfigValue<String> SQ_ENTITY;
	static {
		BUILDER.push("Naga resuurection");
		NAGA_TROPHY_BLOCK = BUILDER.define("naga_trophy_block", "twilightforest:naga_trophy");
		NAGA_RING_BLOCK = BUILDER.define("naga_ring_block", "twilightforest:ironwood_block");
		NAGA_ENTITY = BUILDER.define("naga_entity", "twilightforest:naga");
		BUILDER.pop();
		BUILDER.push("Lich ressurection");
		LICH_TROPHY_BLOCK = BUILDER.define("lich_trophy_block", "twilightforest:lich_trophy");
		LICH_RING_BLOCK = BUILDER.define("lich_ring_block", "minecraft:gold_block");
		LICH_ENTITY = BUILDER.define("lich_entity", "twilightforest:lich");
		BUILDER.pop();
		BUILDER.push("Hydra ressurection");
		HYDRA_TROPHY_BLOCK = BUILDER.define("hydra_trophy_block", "twilightforest:hydra_trophy");
		HYDRA_RING_BLOCK = BUILDER.define("hydra_ring_block", "minecraft:ancient_debris");
		HYDRA_ENTITY = BUILDER.define("hydra_entity", "twilightforest:hydra");
		BUILDER.pop();
		BUILDER.push("Ur-Ghast ressurection");
		URGHAST_TROPHY_BLOCK = BUILDER.define("urghast_trophy_block", "twilightforest:ur_ghast_trophy");
		URGHAST_RING_BLOCK = BUILDER.define("urghast_ring_block", "minecraft:crying_obsidian");
		URGHAST_ENTITY = BUILDER.define("urghast_entity", "twilightforest:ur_ghast");
		BUILDER.pop();
		BUILDER.push("Snow Queen ressurection");
		SQ_TROPHY_BLOCK = BUILDER.define("sq_trophy_block", "twilightforest:snow_queen_trophy");
		SQ_RING_BLOCK = BUILDER.define("sq_ring_block", "minecraft:lapis_block");
		SQ_ENTITY = BUILDER.define("sq_entity", "twilightforest:snow_queen");
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
