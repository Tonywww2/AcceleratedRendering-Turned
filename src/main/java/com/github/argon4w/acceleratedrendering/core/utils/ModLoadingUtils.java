package com.github.argon4w.acceleratedrendering.core.utils;

import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import java.util.HashMap;
import java.util.Map;

public class ModLoadingUtils {
    private static final Map<String, Boolean> MOD_LOADED_CACHE = new HashMap<>();

    public static boolean isModLoaded(String modId) {
        return MOD_LOADED_CACHE.computeIfAbsent(modId, id -> {
            try {
                LoadingModList loadingModList = LoadingModList.get();
                if (loadingModList != null) {
                    return loadingModList.getMods().stream()
                            .map(ModInfo::getModId)
                            .anyMatch(id::equals);
                }
            } catch (Exception e) {
                // 如果早期检查失败,返回 true 让 Mixin 尝试加载
                // 后续会在运行时通过 @Mixin(remap = false) 处理
            }
            return false;
        });
    }

    public static void clearCache() {
        MOD_LOADED_CACHE.clear();
    }

}
