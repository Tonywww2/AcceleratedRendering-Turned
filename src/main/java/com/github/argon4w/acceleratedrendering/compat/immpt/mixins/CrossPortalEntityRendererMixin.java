package com.github.argon4w.acceleratedrendering.compat.immpt.mixins;

import com.github.argon4w.acceleratedrendering.compat.immpt.ImmersivePortalsCompat;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qouteall.imm_ptl.core.render.CrossPortalEntityRenderer;

@Mixin(CrossPortalEntityRenderer.class)
public class CrossPortalEntityRendererMixin {

    @Inject(method = "onEndRenderingEntities(Lcom/mojang/blaze3d/vertex/PoseStack;)V", at = @At("HEAD"), remap = false)
    private static void injectOnEndRenderingEntities(PoseStack matrixStack, CallbackInfo ci) {
        ImmersivePortalsCompat.reducePortalRenderCount(1);
    }

}
