package dimasicserver.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import dimasicserver.configuration.ConfigConfiguration;

@Mod.EventBusSubscriber(modid = "dimasic_server", bus = Mod.EventBusSubscriber.Bus.MOD)
public class DimasicServerModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigConfiguration.SPEC, "tf_ressurect_common.toml");
		});
	}
}
