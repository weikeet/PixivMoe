package me.weicools.pixivmoe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc:
 */
data class Stats(
  @SerializedName("scored_count") @Expose val scored_count: Int,
  @SerializedName("score") @Expose val score: Int,
  @SerializedName("views_count") @Expose val viewsCount: Int,
  @SerializedName("favorited_count") @Expose val favoriteCount: FavoriteCount,
  @SerializedName("commented_count") @Expose val commentedCount: Int
)

data class FavoriteCount(
  @SerializedName("public") @Expose val public: Int,
  @SerializedName("private") @Expose val private: Int
)