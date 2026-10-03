package hellfirepvp.observerlib.common.registry;

import hellfirepvp.observerlib.ObserverLib;
import hellfirepvp.observerlib.api.ObserverProvider;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This class is part of the ObserverLib Mod
 * The complete source code for this mod can be found on github.
 * Class: RegistryProviders
 * Created by HellFirePvP
 * Date: 24.04.2019 / 18:33
 */
public class RegistryProviders {

    public static final ResourceKey<Registry<ObserverProvider<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(ObserverLib.key("observer_providers"));
    private static final Registry<ObserverProvider<?>> REGISTRY = FabricRegistryBuilder.createSimple(REGISTRY_KEY)
            .attribute(RegistryAttribute.SYNCED).buildAndRegister();

    public static void initialize() {

    }

    @Nullable
    public static ObserverProvider<?> getProvider(ResourceLocation key) {
        return REGISTRY.get(key);
    }

    @Nonnull
    public static Registry<ObserverProvider<?>> getRegistry() {
        return REGISTRY;
    }
}
