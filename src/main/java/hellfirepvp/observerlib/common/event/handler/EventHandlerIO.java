package hellfirepvp.observerlib.common.event.handler;

import hellfirepvp.observerlib.common.data.WorldCacheManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

/**
 * This class is part of the ObserverLib Mod
 * The complete source code for this mod can be found on github.
 * Class: EventHandlerIO
 * Created by HellFirePvP
 * Date: 03.07.2019 / 15:35
 */
public class EventHandlerIO {

    public static void onSave(LevelAccessor level) {
        if (level.isClientSide() || !(level instanceof Level)) {
            return;
        }
        WorldCacheManager.getInstance().doSave((Level) level);
    }

}
