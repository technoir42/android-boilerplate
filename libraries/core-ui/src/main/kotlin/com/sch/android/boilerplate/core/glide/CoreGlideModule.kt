package com.sch.android.boilerplate.core.glide

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class CoreGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean = false
}
