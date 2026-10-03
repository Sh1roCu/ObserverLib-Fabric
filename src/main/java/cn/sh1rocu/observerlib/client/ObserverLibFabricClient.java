package cn.sh1rocu.observerlib.client;

import hellfirepvp.observerlib.api.ObserverHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ObserverLibFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ObserverHelper.blockAirRequirement.get(), RenderType.translucent());
    }
}
