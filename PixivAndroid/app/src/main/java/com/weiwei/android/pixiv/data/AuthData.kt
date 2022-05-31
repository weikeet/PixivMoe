package com.weiwei.android.pixiv.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: POST /user/auth
 *
 * {
 * "username":"[:username]",
 * "password":"[:password]"
 * }
 *
 * example
 * curl 'https://api.pixiv.moe/v1/user/auth' \
 * -H 'content-type: application/json' \
 * -H 'accept: application/json' \
 * --data-binary '{"username":"abc","password":"mypassword"}'
 */
data class AuthData(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("message") @Expose val message: String,
  @SerializedName("data") @Expose val data: Data
)

data class Data(
  @SerializedName("access_token") @Expose val accessToken: String,
  @SerializedName("expires_in") @Expose val expiresIn: Int,
  @SerializedName("token_type") @Expose val tokenType: String,
  @SerializedName("scope") @Expose val scope: String,
  @SerializedName("refresh_token") @Expose val refreshToken: String,
  @SerializedName("user") @Expose val user: AuthUser
)

data class AuthUser(
  @SerializedName("id") @Expose val id: String,
  @SerializedName("name") @Expose val name: String,
  @SerializedName("account") @Expose val account: String,
  @SerializedName("is_premium") @Expose val isPremium: Boolean,
  @SerializedName("x_restrict") @Expose val xRestrict: Int,
  @SerializedName("is_mail_authorized") @Expose val isMailAuthorized: Boolean,
  @SerializedName("profile_image_urls") @Expose val profileImageUrls: ProfileImageUrls
)