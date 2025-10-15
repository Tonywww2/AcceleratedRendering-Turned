package com.github.argon4w.acceleratedrendering.compat.immpt;

import org.joml.Matrix4f;

public class ImmersivePortalsMatrixCache {
    private static Matrix4f savedViewMatrix = null;
    private static Matrix4f savedProjectionMatrix = null;
    private static boolean isPortalRendering = false;

    // 在进入传送门渲染前保存原始矩阵
    public static void saveMatrices(Matrix4f view, Matrix4f projection) {
//        System.out.println("Saving matrices for portal rendering.");
//        System.out.printf("View Matrix: %s\n", view);
//        System.out.printf("Projection Matrix: %s\n", projection);
        if (!isPortalRendering) {
            savedViewMatrix = new Matrix4f(view);
            savedProjectionMatrix = new Matrix4f(projection);
            isPortalRendering = true;
        }
    }

    // 传送门渲染结束后清除缓存
    public static void clearMatrices() {
        savedViewMatrix = null;
        savedProjectionMatrix = null;
        isPortalRendering = false;
    }

    // 获取用于剔除的正确矩阵
    public static Matrix4f getViewMatrixForCulling(Matrix4f current) {
        return savedViewMatrix != null ? savedViewMatrix : current;
    }

    public static Matrix4f getProjectionMatrixForCulling(Matrix4f current) {
        return savedProjectionMatrix != null ? savedProjectionMatrix : current;
    }

    public static boolean isPortalRendering() {
        return isPortalRendering;
    }
}