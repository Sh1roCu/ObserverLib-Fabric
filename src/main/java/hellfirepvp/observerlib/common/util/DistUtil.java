package hellfirepvp.observerlib.common.util;


import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

import java.util.function.Supplier;

public class DistUtil {

    public static <T> T unsafeRunForDist(Supplier<Supplier<T>> clientTarget, Supplier<Supplier<T>> serverTarget) {
        return switch (FabricLoader.getInstance().getEnvironmentType()) {
            case EnvType.CLIENT -> clientTarget.get().get();
            case EnvType.SERVER -> serverTarget.get().get();
        };
    }

}
