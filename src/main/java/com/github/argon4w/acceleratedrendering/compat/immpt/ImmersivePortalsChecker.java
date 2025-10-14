package com.github.argon4w.acceleratedrendering.compat.immpt;

import qouteall.imm_ptl.core.render.CrossPortalEntityRenderer;

public class ImmersivePortalsChecker implements ImmersivePortalsCompat.IPortalChecker {
    private boolean isRenderingPortalEntities = false;

    public void setRenderingPortalEntities(boolean renderingPortalEntities) {
        isRenderingPortalEntities = renderingPortalEntities;
    }

    @Override
    public boolean isRenderingCrossPortal() {
        return isRenderingPortalEntities;
//        return CrossPortalEntityRenderer.isRenderingEntityNormally;
    }
}