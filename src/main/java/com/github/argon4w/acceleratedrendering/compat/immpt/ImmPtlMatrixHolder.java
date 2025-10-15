package com.github.argon4w.acceleratedrendering.compat.immpt;

import org.joml.Matrix4f;

/**
 * 简单的单例 holder，用于在 ImmersivePortals 切换 camera 前缓存 projection 矩阵，
 * 供 AR 中其它模块读取（例如 culling provider / decal generator）。
 *
 * 注意：存的是 Matrix4f 的副本，以避免后续 RenderSystem 对象被修改影响缓存。
 */
public enum ImmPtlMatrixHolder {
    INSTANCE;

    private volatile Matrix4f projectionBeforePortal = null;

    public synchronized void setProjectionBeforePortal(Matrix4f m) {
        this.projectionBeforePortal = m == null ? null : new Matrix4f(m);
    }

    public synchronized Matrix4f getProjectionBeforePortal() {
        return projectionBeforePortal == null ? null : new Matrix4f(projectionBeforePortal);
    }

    public synchronized void clear() {
        projectionBeforePortal = null;
    }
}