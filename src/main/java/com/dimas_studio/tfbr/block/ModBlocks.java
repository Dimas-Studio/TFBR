package com.dimas_studio.tfbr.block;

import com.dimas_studio.tfbr.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

import java.util.function.Supplier;

import static com.dimas_studio.tfbr.TFBR.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Block> RESPAWN_NAGA = registryBlock("respawn_naga",
            () -> new RespawnBlockNaga(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
    public static final DeferredBlock<Block> RESPAWN_LICH = registryBlock("respawn_lich",
            () -> new RespawnBlockNaga(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
    public static final DeferredBlock<Block> RESPAWN_HYDRA = registryBlock("respawn_hydra",
            () -> new RespawnBlockNaga(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
    public static final DeferredBlock<Block> RESPAWN_UR_GHAST = registryBlock("respawn_ur_ghast",
            () -> new RespawnBlockNaga(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
    public static final DeferredBlock<Block> RESPAWN_SNOW_QUEEN = registryBlock("respawn_snow_queen",
            () -> new RespawnBlockNaga(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));


    private static <T extends Block>DeferredBlock<T> registryBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registryBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
