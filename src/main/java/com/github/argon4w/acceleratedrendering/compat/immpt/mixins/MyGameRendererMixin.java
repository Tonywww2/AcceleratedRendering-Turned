package com.github.argon4w.acceleratedrendering.compat.immpt.mixins;

import com.github.argon4w.acceleratedrendering.compat.immpt.ImmersivePortalsCompat;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qouteall.imm_ptl.core.render.MyGameRenderer;

import java.util.function.Consumer;

@Mixin(MyGameRenderer.class)
public abstract class MyGameRendererMixin {

    @Inject(
            method = "switchAndRenderTheWorld(Lnet/minecraft/client/multiplayer/ClientLevel;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Ljava/util/function/Consumer;IZ)V",
            at = @At(value = "INVOKE", target = "Ljava/util/function/Consumer;accept(Ljava/lang/Object;)V"),
            remap = false)
    private static void injectBeforeAccept(ClientLevel newWorld, Vec3 thisTickCameraPos, Vec3 lastTickCameraPos, Consumer<Runnable> invokeWrapper, int renderDistance, boolean doRenderHand, CallbackInfo ci) {
        ImmersivePortalsCompat.addPortalRenderCount(2);

    }
    
}
