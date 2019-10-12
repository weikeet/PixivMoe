package me.weicools.pixivmoe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: https://api.pixiv.moe/v1/gallery?tag=nico&page=1
 * GET /gallery?tag=[:tag]&page=[:page]
 */

data class IllustListData(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("response") @Expose val response: List<IllustListResponse>,
  @SerializedName("count") @Expose val count: Int,
  @SerializedName("pagination") @Expose val pagination: Pagination,
  @SerializedName("expires_at") @Expose val expiresAt: Int
)

data class IllustListResponse(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("title") @Expose val title: String,
  @SerializedName("image_urls") @Expose val imageUrls: ImageUrls,
  @SerializedName("stats") @Expose val stats: Stats,
  @SerializedName("unique_id") @Expose val uniqueId: String
)