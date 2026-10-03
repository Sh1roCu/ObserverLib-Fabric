package hellfirepvp.observerlib.client.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;

/**
 * This class is part of the ObserverLib Mod
 * The complete source code for this mod can be found on github.
 * Class: ClientTickHelper
 * Created by HellFirePvP
 * Date: 30.04.2019 / 22:58
 */
public class ClientTickHelper {

    public static final ClientTickHelper INSTANCE = new ClientTickHelper();

    private static long tick = 0;

    private ClientTickHelper() {
    }

    public void attachEventListener() {
        ClientTickEvents.END_CLIENT_TICK.register(this::tick);
    }

    public static long getClientTick() {
        return tick;
    }

    private void tick(Minecraft client) {
        tick++;
    }
}
