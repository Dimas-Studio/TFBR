package com.dimas_studio.tfbr.events;

import com.dimas_studio.tfbr.TFBR;
import com.dimas_studio.tfbr.block.ModBlocks;
import com.dimas_studio.tfbr.utils.WorldBlockManagment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import twilightforest.block.TFChestBlock;
import twilightforest.entity.boss.*;
import twilightforest.util.EntityUtil;

import static com.dimas_studio.tfbr.TFBR.MODID;


public class BossEvent {
    @Mod.EventBusSubscriber(modid = MODID)
    public static class BossDeathEvent {
        @SubscribeEvent
        public static void onEntityDeath(LivingDeathEvent event){
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
                summonBlock(urGhast.level(), EntityUtil.bossChestLocation(urGhast), ModBlocks.RESPAWN_UR_GHAST.get(), -1);
            }
            if (event.getEntity() instanceof SnowQueen snowQueen) {
                summonBlock(snowQueen.level(), EntityUtil.bossChestLocation(snowQueen), ModBlocks.RESPAWN_SNOW_QUEEN.get(), -2);
            }
        }
    }


    public static void summonBlock(Level world, BlockPos blockPos, Block block, int extraY) {
        if (world.getBlockState(blockPos).getBlock() instanceof TFChestBlock) {
            WorldBlockManagment.setBlock(BlockPos.containing(blockPos.getX(), blockPos.getY()+extraY, blockPos.getZ()), world, block);
            return;
        }
        TFBR.queueServerWork(40, () -> summonBlock(world, blockPos, block, extraY));
    }
}
