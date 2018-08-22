package com.weicools.pixiv.moe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc:
 */
data class ImageUrls(
    @SerializedName("px_128x128") @Expose val px128x128: String,
    @SerializedName("px_480mw") @Expose val px480mw: String,
    @SerializedName("large") @Expose val large: String,
    @SerializedName("small") @Expose val small: String,
    @SerializedName("medium") @Expose val medium: String
)