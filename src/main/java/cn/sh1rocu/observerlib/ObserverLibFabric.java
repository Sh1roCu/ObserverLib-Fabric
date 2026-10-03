package cn.sh1rocu.observerlib;

import hellfirepvp.observerlib.ObserverLib;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class ObserverLibFabric implements ModInitializer {

    @Nullable
    private static WeakReference<MinecraftServer> server;

    @Nullable
    public static MinecraftServer getServer() {
        if (server == null) {
            return null;
        }
        return server.get();
    }

    @Override
    public void onInitialize() {
        ObserverLib.init();

        ServerLifecycleEvents.SERVER_STARTING.register((server) -> ObserverLibFabric.server = new WeakReference<>(server));
    }
}
