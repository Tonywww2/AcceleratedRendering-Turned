package com.github.argon4w.acceleratedrendering.compat.immpt;

import net.minecraftforge.fml.loading.LoadingModList;

public class ImmersivePortalsCompat {
    public static final boolean MOD_LOADED;

    static {
        MOD_LOADED = LoadingModList.get().getModFileById("immersive_portals") != null;

    }

}