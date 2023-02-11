/*
 * Copyright (c) Copyright 2020 - 2022 The Cat Town Craft and contributors.
 * This source code is subject to the terms of the GNU Lesser General Public
 * License, version 3. If a copy of the LGPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package com.plusls.carpet;

import lombok.Getter;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import top.hendrixshen.magiclib.util.FabricUtil;
import top.hendrixshen.magiclib.util.VersionParser;

public class PluslsCarpetAdditionReference {
    private static final String currentModIdentifier = "${mod_id}-${minecraft_version_id}";
    @Getter
    private static final String modIdentifier = "${mod_id}";
    @Getter
    private static final String currentModName = FabricLoader.getInstance().getModContainer(currentModIdentifier).orElseThrow(RuntimeException::new).getMetadata().getName();
    @Getter
    private static final String modName = "${mod_name}";
    @Getter
    private static final String modVersion = FabricLoader.getInstance().getModContainer(currentModIdentifier).orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();
    @Getter
    private static final String modVersionType = VersionParser.getVersionType(modVersion);
    @Getter
    private static final Logger logger = LogManager.getLogger(modIdentifier);
    public static final boolean tisCarpetLoaded = FabricUtil.isModLoaded("carpet-tis-addition", ">=1.27.0");

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ResourceLocation identifier(String path) {
        return new ResourceLocation(PluslsCarpetAdditionReference.modIdentifier, path);
    }
}
