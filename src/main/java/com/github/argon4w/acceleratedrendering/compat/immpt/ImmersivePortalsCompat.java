package com.github.argon4w.acceleratedrendering.compat.immpt;

import com.github.argon4w.acceleratedrendering.core.utils.ModLoadingUtils;

public class ImmersivePortalsCompat {
    private static final boolean MOD_LOADED;
    private static final IPortalChecker CHECKER;

    static {
        MOD_LOADED = ModLoadingUtils.isModLoaded("immersive_portals");;
        CHECKER = new ImmersivePortalsChecker();;

    }

    public static boolean shouldSkipRendering() {
        return MOD_LOADED && CHECKER.isRenderingCrossPortal();
    }

    public interface IPortalChecker {
        boolean isRenderingCrossPortal();
    }
}