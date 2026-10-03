package hellfirepvp.observerlib.common;

import hellfirepvp.observerlib.ObserverLib;
import hellfirepvp.observerlib.api.ObserverHelper;
import hellfirepvp.observerlib.common.block.BlockAirRequirement;
import hellfirepvp.observerlib.common.change.StructureIntegrityObserver;
import hellfirepvp.observerlib.common.data.WorldCacheIOThread;
import hellfirepvp.observerlib.common.data.WorldCacheManager;
import hellfirepvp.observerlib.common.event.BlockChangeNotifier;
import hellfirepvp.observerlib.common.registry.RegistryProviders;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;

/**
 * This class is part of the ObserverLib Mod
 * The complete source code for this mod can be found on github.
 * Class: CommonProxy
 * Created by HellFirePvP
 * Date: 06.03.2019 / 21:25
 */
public class CommonProxy {

    public void initialize() {
        BlockChangeNotifier.addListener(new StructureIntegrityObserver());
    }

    public void attachLifecycle() {
        this.registerBlocks();
        this.registerRegistries();
    }

    private void registerBlocks() {
        ObserverHelper.blockAirRequirement = () -> Registry.register(BuiltInRegistries.BLOCK,
                ObserverLib.key("air_preview"), new BlockAirRequirement());
    }

    private void registerRegistries() {
        RegistryProviders.initialize();
    }

    public void attachEventHandlers() {
        ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStarted);
        ServerLifecycleEvents.SERVER_STOPPING.register(this::onServerStopping);
    }

    private void onServerStarted(MinecraftServer server) {
        WorldCacheIOThread.onServerStart();
    }

    private void onServerStopping(MinecraftServer server) {
        WorldCacheManager.scheduleSaveAll();
        WorldCacheIOThread.onServerStop();
        WorldCacheManager.cleanUp();
    }

}
