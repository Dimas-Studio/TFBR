package com.dimas_studio.tfbr.events;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.block.ModBlocks;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import twilightforest.block.TFChestBlock;
import twilightforest.entity.boss.*;
import twilightforest.init.TFBlocks;
import twilightforest.util.entities.EntityUtil;

import static com.dimas_studio.tfbr.TFBR.MODID;
import static com.dimas_studio.tfbr.utils.WorldBlockManagment.summonBlock;


@EventBusSubscriber(modid = MODID)
public class BossEvent {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        if (event == null) {
            return;
        }
        if (event.getEntity() instanceof Naga naga) {
            summonBlock(naga.level(), EntityUtil.bossChestLocation(naga), ModBlocks.RESPAWN_NAGA.get(), -1);
        }
        if (event.getEntity() instanceof Lich lich) {
            summonBlock(lich.level(), EntityUtil.bossChestLocation(lich), ModBlocks.RESPAWN_LICH.get(), -1);
        }
        if (event.getEntity() instanceof Hydra hydra) {
            summonBlock(hydra.level(), EntityUtil.bossChestLocation(hydra), ModBlocks.RESPAWN_HYDRA.get(), -1);
        }
        if (event.getEntity() instanceof UrGhast urGhast) {
            summonBlock(urGhast.level(), EntityUtil.bossChestLocation(urGhast), ModBlocks.RESPAWN_UR_GHAST.get(), -2);
            int x = EntityUtil.bossChestLocation(urGhast).getX();
            int y = EntityUtil.bossChestLocation(urGhast).getY();
            int z = EntityUtil.bossChestLocation(urGhast).getZ();
            WorldBlockManagment.setBlockAroundFiled(x,y-3,z,4,urGhast.level(), TFBlocks.ENCASED_TOWERWOOD.get());
        }
        if (event.getEntity() instanceof SnowQueen snowQueen) {
            summonBlock(snowQueen.level(), EntityUtil.bossChestLocation(snowQueen), ModBlocks.RESPAWN_SNOW_QUEEN.get(), -2);
            LogUtils.getLogger().info("12353432");
        }
    }
}



