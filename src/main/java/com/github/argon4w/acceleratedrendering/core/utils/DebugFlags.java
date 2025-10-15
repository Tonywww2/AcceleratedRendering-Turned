package com.github.argon4w.acceleratedrendering.core.utils;

import java.util.concurrent.atomic.AtomicBoolean;

public final class DebugFlags {
    // skip entire compute-stage pipeline (mesh uploading + transform + processing + culling)
    public static final AtomicBoolean DISABLE_ALL_COMPUTE = new AtomicBoolean(false);

    // finer-grained toggles:
    public static final AtomicBoolean DISABLE_MESH_UPLOADING = new AtomicBoolean(false);
    public static final AtomicBoolean DISABLE_TRANSFORM_DISPATCH = new AtomicBoolean(false);
    public static final AtomicBoolean DISABLE_CULLING_DISPATCH = new AtomicBoolean(false);

    private DebugFlags() {}
}