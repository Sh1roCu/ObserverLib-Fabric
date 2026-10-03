package cn.sh1rocu.observerlib.mixin.accessor;

import net.minecraft.world.level.storage.LevelResource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LevelResource.class)
public interface LevelResourceAccessor {
    @Invoker("<init>")
    static LevelResource ol$create(String id) {
        throw new UnsupportedOperationException();
    }
}
