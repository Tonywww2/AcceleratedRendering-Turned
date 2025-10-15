package com.github.argon4w.acceleratedrendering.compat.immediatelyfast.mixins.plugin;

import com.github.argon4w.acceleratedrendering.compat.AbstractCompatMixinPlugin;

import java.util.List;

public class ImmediatelyFastCompatPlugin extends AbstractCompatMixinPlugin {

    @Override
    protected List<String> getModIDs() {
        return List.of("immediatelyfast");
    }
}