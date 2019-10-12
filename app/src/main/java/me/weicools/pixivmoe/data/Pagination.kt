package me.weicools.pixivmoe.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc:
 */
data class Pagination(
  @SerializedName("previous") @Expose val previous: Any,
  @SerializedName("next") @Expose val next: Int,
  @SerializedName("current") @Expose val current: Int,
  @SerializedName("per_page") @Expose val perPage: Int,
  @SerializedName("total") @Expose val total: Int,
  @SerializedName("pages") @Expose val pages: Int
)