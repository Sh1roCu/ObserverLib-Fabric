package hellfirepvp.observerlib;

import hellfirepvp.observerlib.api.ObserverHelper;
import hellfirepvp.observerlib.client.ClientProxy;
import hellfirepvp.observerlib.common.CommonProxy;
import hellfirepvp.observerlib.common.api.MatcherObserverHelper;
import hellfirepvp.observerlib.common.util.DistUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is part of the ObserverLib Mod
 * The complete source code for this mod can be found on github.
 * Class: ObserverLib
 * Created by HellFirePvP
 * Date: 06.03.2019 / 21:18
 */
public class ObserverLib {

    public static final String MODID = "observerlib";
    public static final String NAME = "ObserverLib";

    public static final Logger log = LogManager.getLogger(NAME);
    private static ObserverLib instance;

    private final ModContainer modContainer;
    private final CommonProxy proxy;

    public static void init(){
        new ObserverLib();
    }

    private ObserverLib() {
        instance = this;
        this.modContainer = FabricLoader.getInstance().getModContainer(MODID).orElseThrow();

        this.proxy = DistUtil.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        this.proxy.initialize();
        this.proxy.attachLifecycle();
        this.proxy.attachEventHandlers();

        ObserverHelper.setHelper(new MatcherObserverHelper());
    }

    public static CommonProxy getProxy() {
        return getInstance().proxy;
    }

    public static ModContainer getModContainer() {
        return getInstance().modContainer;
    }

    public static ObserverLib getInstance() {
        return instance;
    }

    public static ResourceLocation key(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}