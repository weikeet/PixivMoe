package com.weicools.pixiv.moe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: https://api.pixiv.moe/v1/search?word=fgo&page=1
 * GET /ranking?word=[:word]&page=[:page]
 */

data class SearchData(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("response") @Expose val response: List<SearchResponse>,
  @SerializedName("count") @Expose val count: Int,
  @SerializedName("pagination") @Expose val pagination: Pagination
)

data class SearchResponse(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("title") @Expose val title: String,
  @SerializedName("image_urls") @Expose val imageUrls: ImageUrls,
  @SerializedName("stats") @Expose val stats: Stats,
  @SerializedName("unique_id") @Expose val uniqueId: String
)