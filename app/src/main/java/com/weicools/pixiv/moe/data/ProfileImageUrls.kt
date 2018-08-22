package com.weicools.pixiv.moe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc:
 */
data class ProfileImageUrls(
    @SerializedName("px_50x50") @Expose val px50x50: String,
    @SerializedName("medium") @Expose val medium: String
)