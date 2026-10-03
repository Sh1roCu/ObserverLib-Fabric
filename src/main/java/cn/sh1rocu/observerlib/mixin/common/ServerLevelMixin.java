package cn.sh1rocu.observerlib.mixin.common;

import hellfirepvp.observerlib.common.event.handler.EventHandlerIO;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProgressListener;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {
    @Inject(method = "save", at = @At("TAIL"))
    private void onSaveWorld(@Nullable ProgressListener progress, boolean flush, boolean skipSave, CallbackInfo ci) {
        if (!skipSave) {
            EventHandlerIO.onSave((ServerLevel) (Object) this);
        }
    }
}
