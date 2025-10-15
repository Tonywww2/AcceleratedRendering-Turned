package com.github.argon4w.acceleratedrendering.compat.sodium.mixins.plugin;

import com.github.argon4w.acceleratedrendering.compat.AbstractCompatMixinPlugin;

import java.util.List;

public class SodiumCompatMixinPlugin extends AbstractCompatMixinPlugin {

    @Override
    protected List<String> getModIDs() {
        return List.of("sodium");
    }
}