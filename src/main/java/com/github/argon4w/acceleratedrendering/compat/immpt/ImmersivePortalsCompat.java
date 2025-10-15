package com.github.argon4w.acceleratedrendering.compat.immpt;

import com.github.argon4w.acceleratedrendering.core.utils.ModLoadingUtils;

public class ImmersivePortalsCompat {
    public static final boolean MOD_LOADED;

    static {
        MOD_LOADED = ModLoadingUtils.isModLoaded("immersive_portals");;

    }

}