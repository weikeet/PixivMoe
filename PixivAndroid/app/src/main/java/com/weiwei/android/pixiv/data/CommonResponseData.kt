package com.weiwei.android.pixiv.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Weicools Create on 2018.08.22
 *
 * desc: PUT /favourite/[:illust_id]
 *
 * example
 * curl 'https://api.pixiv.moe/v1/favourite/46453302' \
 * -X PUT \
 * -H 'access-token: AAA' \
 * -H 'content-type: application/json' \
 * -H 'accept: application/json'
 */

data class CommonResponseData(
  @SerializedName("status") @Expose val status: String,
  @SerializedName("message") @Expose val message: String
)

/*
{
    "status":"success",
    "message":"をブックマークに追加しました"
}
{
    "status":"failure",
    "message":"あなたは既にブックマークに追加しました"
}
 */