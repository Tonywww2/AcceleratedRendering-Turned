package com.github.argon4w.acceleratedrendering.compat.immpt;

import com.github.argon4w.acceleratedrendering.configs.FeatureConfig;
import com.github.argon4w.acceleratedrendering.configs.FeatureStatus;
import com.github.argon4w.acceleratedrendering.core.utils.ModLoadingUtils;

public class ImmersivePortalsCompat {
    private static final boolean MOD_LOADED;
    public static final IPortalChecker CHECKER;

    static {
        MOD_LOADED = ModLoadingUtils.isModLoaded("immersive_portals");;
        CHECKER = new ImmersivePortalsChecker();;

    }

    public static boolean shouldSkipRendering() {
        System.out.println("ImmersivePortalsCompat.shouldSkipRendering: " +
                (FeatureConfig.CONFIG.immptCompatFeatureStatus.get() == FeatureStatus.ENABLED) + ", " +
                MOD_LOADED + ", " +
                CHECKER.isRenderingCrossPortal()
        );
        return FeatureConfig.CONFIG.immptCompatFeatureStatus.get() == FeatureStatus.ENABLED &&
                MOD_LOADED &&
                CHECKER.isRenderingCrossPortal();
    }

    public interface IPortalChecker {
        boolean isRenderingCrossPortal();
    }
}