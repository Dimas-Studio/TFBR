package dimasicserver.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import dimasicserver.configuration.ConfigConfiguration;

import dimasicserver.DimasicServerMod;

@Mod.EventBusSubscriber
public class BossrespawnProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(ConfigConfiguration.NAGA_ENTITY.get())) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + "" + (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:nagarespawn")))));
			DimasicServerMod.LOGGER.info(entity.getDisplayName().getString());
		} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(ConfigConfiguration.LICH_ENTITY.get())) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + "" + (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:lichspawn")))));
			DimasicServerMod.LOGGER.info(entity.getDisplayName().getString());
		} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(ConfigConfiguration.HYDRA_ENTITY.get())) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + "" + (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:hydraspawn")))));
		} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(ConfigConfiguration.URGHAST_ENTITY.get())) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + "" + (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:ur_ghastspawn")))));
		} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(ConfigConfiguration.SQ_ENTITY.get())) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + "" + (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:snowqueenspawn")))));
		}
	}
}
