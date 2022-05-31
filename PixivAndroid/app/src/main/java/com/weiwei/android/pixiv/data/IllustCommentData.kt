package com.weiwei.android.pixiv.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: https://api.pixiv.moe/v1/illust/comments/47527196?page=1
 * GET /illust/comments/[:illust_id]?page=[:page]
 */

data class IllustCommentData(
  @SerializedName("total_comments") @Expose val totalComments: Int,
  @SerializedName("comments") @Expose val comments: List<Comment>
)

data class Comment(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("comment") @Expose val comment: String,
  @SerializedName("date") @Expose val date: String,
  @SerializedName("user") @Expose val user: CommentUser,
  @SerializedName("parent_comment") @Expose val parentComment: List<Any>
)

data class CommentUser(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("name") @Expose val name: String,
  @SerializedName("account") @Expose val account: String,
  @SerializedName("profile_image_urls") @Expose val profileImageUrls: ProfileImageUrls
)