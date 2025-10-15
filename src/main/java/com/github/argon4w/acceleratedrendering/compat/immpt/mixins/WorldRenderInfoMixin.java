package com.github.argon4w.acceleratedrendering.compat.immpt.mixins;

import com.github.argon4w.acceleratedrendering.compat.immpt.ImmPtlMatrixHolder;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qouteall.imm_ptl.core.render.context_management.WorldRenderInfo;

import java.util.function.Consumer;

/**
 * Mixin 到 ImmersivePortals 的 MyGameRenderer.switchAndRenderTheWorld，
 * 在 setCamera(newCamera) 调用之前捕捉当前的 projection 矩阵并缓存到 ImmPtlMatrixHolder。
 *
 * 精确注入点：在 ieGameRenderer.setCamera(newCamera) 调用之前（最接近实际切 camera 的地方）。
 */
@Mixin(WorldRenderInfo.class)
public class WorldRenderInfoMixin {

    @Unique
    private static final ImmPtlMatrixHolder HOLDER =
            ImmPtlMatrixHolder.INSTANCE;

    @Inject(
            method = "adjustCameraPos(Lnet/minecraft/client/Camera;)V",
            at = @At("HEAD"),
            remap = false
    )
    private static void onBeforeSetCamera(
            Camera camera, CallbackInfo ci
    ) {
        // 复制一份矩阵并缓存（RenderSystem 返回的是可变对象，故复制）
        Matrix4f currentProj = new Matrix4f(RenderSystem.getProjectionMatrix());
        HOLDER.setProjectionBeforePortal(currentProj);
    }
}