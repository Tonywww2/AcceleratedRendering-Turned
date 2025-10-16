package com.github.argon4w.acceleratedrendering.compat.immpt;

import net.minecraftforge.fml.loading.LoadingModList;

public class ImmersivePortalsCompat {
    public static final boolean MOD_LOADED;
    public static int portalRenderCount = 0;

    static {
        MOD_LOADED = LoadingModList.get().getModFileById("immersive_portals") != null;

    }

    public static void addPortalRenderCount(int n) {
        portalRenderCount = Math.max(50, portalRenderCount + n);
    }

    public static void reducePortalRenderCount(int n) {
        portalRenderCount = Math.max(0, portalRenderCount - n);
    }

}