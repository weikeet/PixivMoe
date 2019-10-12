package me.weicools.pixivmoe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: https://api.pixiv.moe/v1/illust/50110342
 * GET /illust/[:illust_id]
 */

data class IllustDetailData(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("count") @Expose val count: Int,
  @SerializedName("response") @Expose val response: IllustDetailResponse
)

data class IllustDetailResponse(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("title") @Expose val title: String,
  @SerializedName("caption") @Expose val caption: String,
  @SerializedName("tags") @Expose val tags: List<String>,
  @SerializedName("tools") @Expose val tools: List<Any>,
  @SerializedName("image_urls") @Expose val imageUrls: ImageUrls,
  @SerializedName("width") @Expose val width: Int,
  @SerializedName("height") @Expose val height: Int,
  @SerializedName("stats") @Expose val stats: Stats,
  @SerializedName("publicity") @Expose val publicity: Int,
  @SerializedName("age_limit") @Expose val age_limit: String,
  @SerializedName("created_time") @Expose val createdTime: String,
  @SerializedName("reuploaded_time") @Expose val reUploadedTime: String,
  @SerializedName("user") @Expose val user: IllustDetailUser,
  @SerializedName("page_count") @Expose val pageCount: Int,
  @SerializedName("book_style") @Expose val bookStyle: String,
  @SerializedName("type") @Expose val type: String,
  @SerializedName("metadata") @Expose val metadata: Any,
  @SerializedName("content_type") @Expose val contentType: Any
)

data class IllustDetailUser(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("account") @Expose val account: String,
  @SerializedName("name") @Expose val name: String,
  @SerializedName("profile_image_urls") @Expose val profileImageUrls: ProfileImageUrls,
  @SerializedName("stats") @Expose val stats: Stats,
  @SerializedName("profile") @Expose val profile: Any
)

data class IllustRequestError(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("has_error") @Expose val hasError: Boolean,
  @SerializedName("errors") @Expose val errors: Errors
)

data class Errors(
  @SerializedName("system") @Expose val system: System
)

data class System(
  @SerializedName("message") @Expose val message: String,
  @SerializedName("code") @Expose val code: Int
)