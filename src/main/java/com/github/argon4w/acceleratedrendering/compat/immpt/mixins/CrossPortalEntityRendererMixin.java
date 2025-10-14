package com.github.argon4w.acceleratedrendering.compat.immpt.mixins;

import com.github.argon4w.acceleratedrendering.compat.immpt.ImmersivePortalsChecker;
import com.github.argon4w.acceleratedrendering.compat.immpt.ImmersivePortalsCompat;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qouteall.imm_ptl.core.render.CrossPortalEntityRenderer;

@Mixin(CrossPortalEntityRenderer.class)
public class CrossPortalEntityRendererMixin {

    @Inject(
            method = "onEndRenderingEntities(Lcom/mojang/blaze3d/vertex/PoseStack;)V",
            at=@At("HEAD"), remap = false
    )
    private static void onEndRenderingEntitiesHead(PoseStack matrixStack, CallbackInfo ci) {
        ((ImmersivePortalsChecker) ImmersivePortalsCompat.CHECKER).setRenderingPortalEntities(true);
//        System.out.println("CrossPortalEntityRendererMixin: setRenderingPortalEntities(true)");

    }
    @Inject(
            method = "onEndRenderingEntities(Lcom/mojang/blaze3d/vertex/PoseStack;)V",
            at=@At("RETURN"), remap = false
    )
    private static void onEndRenderingEntitiesEnd(PoseStack matrixStack, CallbackInfo ci) {
        ((ImmersivePortalsChecker) ImmersivePortalsCompat.CHECKER).setRenderingPortalEntities(false);
//        System.out.println("CrossPortalEntityRendererMixin: setRenderingPortalEntities(false)");

    }
}
