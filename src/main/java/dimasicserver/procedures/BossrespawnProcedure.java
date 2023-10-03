package dimasicserver.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;
import java.util.HashMap;

import dimasicserver.configuration.ConfigConfiguration;

import dimasicserver.DimasicServerMod;

public class BossrespawnProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency world for procedure Bossrespawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency x for procedure Bossrespawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency y for procedure Bossrespawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency z for procedure Bossrespawn!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DimasicServerMod.LOGGER.warn("Failed to load dependency entity for procedure Bossrespawn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((ForgeRegistries.ENTITIES.getKey(entity.getType()).toString()).equals(ConfigConfiguration.NAGA_ENTITY.get())) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + ""
								+ (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:nagarespawn")))));
			}
			System.out.println(entity.getDisplayName().getString());
		} else if ((ForgeRegistries.ENTITIES.getKey(entity.getType()).toString()).equals(ConfigConfiguration.LICH_ENTITY.get())) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + ""
								+ (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:lichspawn")))));
			}
			System.out.println(entity.getDisplayName().getString());
		} else if ((ForgeRegistries.ENTITIES.getKey(entity.getType()).toString()).equals(ConfigConfiguration.HYDRA_ENTITY.get())) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + ""
								+ (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:hydraspawn")))));
			}
		} else if ((ForgeRegistries.ENTITIES.getKey(entity.getType()).toString()).equals(ConfigConfiguration.URGHAST_ENTITY.get())) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + ""
								+ (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:ur_ghastspawn")))));
			}
		} else if ((ForgeRegistries.ENTITIES.getKey(entity.getType()).toString()).equals(ConfigConfiguration.SQ_ENTITY.get())) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("setblock " + (new java.text.DecimalFormat("######## ").format(x) + "" + (new java.text.DecimalFormat("### ").format(y) + ""
								+ (new java.text.DecimalFormat("######## ").format(z) + "dimasic_server:snowqueenspawn")))));
			}
		}
	}
}
