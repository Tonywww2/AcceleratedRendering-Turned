package com.github.argon4w.acceleratedrendering.compat.immpt.mixins.plugin;

import com.github.argon4w.acceleratedrendering.compat.AbstractCompatMixinPlugin;

import java.util.List;

public class ImmersivePortalsCompactPlugin extends AbstractCompatMixinPlugin {

    @Override
    protected List<String> getModIDs() {
        return List.of("immersive_portals");
    }
}
