/*
 * This file is part of SuperLyric.
 *
 * SuperLyric is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2025-2026 HChenX
 */
package com.hchen.superlyric.provider.cider;

import androidx.annotation.NonNull;

import com.hchen.processor.HookThis;
import com.hchen.superlyric.provider.base.LyricPlan;
import com.hchen.superlyric.provider.base.MusicProvider;
import com.hchen.superlyric.provider.kugou.KuGouApiSource;

/**
 * Cider 歌词提供者。
 * <p>
 * 公开资料没有 Cider Android 的歌词模型。身份用宿主 {@code MediaSession} 的歌名、
 * 歌手、时长和可用 media id；歌词只走酷狗检索。检索未命中是暂时失败，不下发纯音乐占位。
 */
@HookThis(targetPackage = "com.cidercollective.cider")
public class CiderProvider extends MusicProvider {
    private static final String TAG = "CiderProvider";

    @NonNull
    @Override
    protected String getProviderTag() {
        return TAG;
    }

    @NonNull
    @Override
    protected LyricPlan createLyricPlan() {
        return new LyricPlan(null, new KuGouApiSource());
    }
}
