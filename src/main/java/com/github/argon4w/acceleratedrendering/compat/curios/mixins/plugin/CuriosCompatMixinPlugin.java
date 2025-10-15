package com.github.argon4w.acceleratedrendering.compat.curios.mixins.plugin;

import com.github.argon4w.acceleratedrendering.compat.AbstractCompatMixinPlugin;

import java.util.List;

public class CuriosCompatMixinPlugin extends AbstractCompatMixinPlugin {

    @Override
    protected List<String> getModIDs() {
        return List.of("curios");
    }
}
