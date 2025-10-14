package com.github.argon4w.acceleratedrendering.compat.immpt;

import qouteall.imm_ptl.core.render.CrossPortalEntityRenderer;

class ImmersivePortalsChecker implements ImmersivePortalsCompat.IPortalChecker {
    @Override
    public boolean isRenderingCrossPortal() {
        return CrossPortalEntityRenderer.isRenderingEntityNormally;
    }
}