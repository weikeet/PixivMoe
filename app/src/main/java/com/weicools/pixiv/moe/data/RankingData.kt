package com.weicools.pixiv.moe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: https://api.pixiv.moe/v1/ranking?page=1
 * GET /ranking?page=[:page]
 */
data class RankingData(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("response") @Expose val response: RankingResponse,
  @SerializedName("count") @Expose val count: Int
)

data class RankingResponse(
  @SerializedName("content") @Expose val content: String,
  @SerializedName("mode") @Expose val mode: String,
  @SerializedName("date") @Expose val date: String,
  @SerializedName("works") @Expose val works: List<Works>
)

data class Works(
  @SerializedName("rank") @Expose val rank: Int,
  @SerializedName("previous_rank") @Expose val previousRank: Int,
  @SerializedName("work") @Expose val work: Work,
  @SerializedName("unique_id") @Expose val uniqueId: String
)

data class Work(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("title") @Expose val title: String,
  @SerializedName("caption") @Expose val caption: Any,
  @SerializedName("tags") @Expose val tags: List<String>,
  @SerializedName("tools") @Expose val tools: Any,
  @SerializedName("image_urls") @Expose val imageUrls: ImageUrls,
  @SerializedName("width") @Expose val width: Int,
  @SerializedName("height") @Expose val height: Int,
  @SerializedName("stats") @Expose val stats: Stats,
  @SerializedName("publicity") @Expose val publicity: Int,
  @SerializedName("age_limit") @Expose val ageLimit: String,
  @SerializedName("created_time") @Expose val createdTime: String,
  @SerializedName("reuploaded_time") @Expose val reUploadedTime: String,
  @SerializedName("user") @Expose val user: User,
  @SerializedName("is_manga") @Expose val isManga: Any,
  @SerializedName("is_liked") @Expose val isLiked: Any,
  @SerializedName("favorite_id") @Expose val favoriteId: Any,
  @SerializedName("page_count") @Expose val pageCount: Int,
  @SerializedName("book_style") @Expose val bookStyle: String,
  @SerializedName("type") @Expose val type: String,
  @SerializedName("metadata") @Expose val metadata: Any,
  @SerializedName("content_type") @Expose val contentType: Any,
  @SerializedName("sanity_level") @Expose val sanityLevel: String
)

data class User(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("account") @Expose val account: String,
  @SerializedName("name") @Expose val name: String,
  @SerializedName("is_following") @Expose val isFollowing: Any,
  @SerializedName("is_follower") @Expose val isFollower: Any,
  @SerializedName("is_friend") @Expose val isFriend: Any,
  @SerializedName("is_premium") @Expose val isPremium: Any,
  @SerializedName("profile_image_urls") @Expose val profileImageUrls: ProfileImageUrls,
  @SerializedName("stats") @Expose val stats: Stats,
  @SerializedName("profile") @Expose val profile: Any
)