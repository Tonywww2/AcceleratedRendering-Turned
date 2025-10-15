package com.github.argon4w.acceleratedrendering.compat.immpt.mixins;

import com.github.argon4w.acceleratedrendering.compat.immpt.*;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qouteall.imm_ptl.core.render.CrossPortalEntityRenderer;

@Mixin(CrossPortalEntityRenderer.class)
public class CrossPortalEntityRendererMixin {

    @Inject(
            method = "onBeginRenderingEntities(Lcom/mojang/blaze3d/vertex/PoseStack;)V",
            at = @At("HEAD"),
            remap = false
    )
    private static void saveOriginalMatricesBeforePortalRendering(PoseStack matrixStack, CallbackInfo ci) {
        // 在 IP 修改矩阵之前保存原始矩阵
        ImmersivePortalsMatrixCache.saveMatrices(
                RenderSystem.getModelViewMatrix(),
                RenderSystem.getProjectionMatrix()
        );
    }

    @Inject(
            method = "onEndRenderingEntities(Lcom/mojang/blaze3d/vertex/PoseStack;)V",
            at = @At("RETURN"),
            remap = false
    )
    private static void restoreMatricesAfterPortalRendering(PoseStack matrixStack, CallbackInfo ci) {
        ImmersivePortalsMatrixCache.clearMatrices();
    }
}