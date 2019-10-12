package me.weicools.pixivmoe.api;

import me.weicools.pixivmoe.data.AuthData;
import me.weicools.pixivmoe.data.CommonResponseData;
import me.weicools.pixivmoe.data.IllustCommentData;
import me.weicools.pixivmoe.data.IllustDetailData;
import me.weicools.pixivmoe.data.IllustListData;
import me.weicools.pixivmoe.data.RankingData;
import me.weicools.pixivmoe.data.SearchData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Create by weicools on 2018.07.10
 *
 * desc: https://github.com/LoveLiveSunshine/pixiv.moe
 */
public interface PixivMoeApi {
  String BASE_URL = "https://api.pixiv.moe/v1/";

  /**
   * Ranking List
   * request: GET /ranking?page=[:page]
   * example: curl 'https://api.pixiv.moe/v1/ranking?page=1'
   *
   * @param page page
   * @return ranking list
   */
  @GET("ranking")
  Observable<RankingData> getRankingList(@Query("page") int page);

  /**
   * Search
   * request: GET /ranking?word=[:word]&page=[:page]
   * example: curl 'https://api.pixiv.moe/v1/search?word=fgo&page=1'
   *
   * @param word keyword
   * @param page page
   * @return search result
   */
  @GET("ranking")
  Observable<SearchData> getSearchData(@Query("word") String word, @Query("page") int page);

  /**
   * Illust List
   * request:GET /gallery?tag=[:tag]&page=[:page]
   * example:curl 'https://api.pixiv.moe/v1/gallery?tag=nico&page=1'
   *
   * @param tag tag
   * @param page page
   * @return Illust List data
   */
  @GET("gallery")
  Observable<IllustListData> getIllustList(@Query("tag") String tag, @Query("page") int page);

  /**
   * Illust Detail
   * request: GET /illust/[:illust_id]
   * example: curl 'https://api.pixiv.moe/v1/illust/50110342'
   *
   * @param illustId illust Id
   * @return Illust Detail data
   */
  @GET("illust/{illust_id}")
  Observable<IllustDetailData> getIllustDetail(@Path("illust_id") int illustId);

  /**
   * Illust Comments
   * request: GET /illust/comments/[:illust_id]?page=[:page]
   * example: curl 'https://api.pixiv.moe/v1/illust/comments/47527196?page=1'
   *
   * @param illustId illust Id
   * @param page page
   * @return Illust Comments data
   */
  @GET("illust/comments/{illust_id}")
  Observable<IllustCommentData> getIllustComments(@Path("illust_id") int illustId, @Query("page") int page);

  /**
   * add Favourite
   * request
   * PUT /favourite/[:illust_id]
   * example
   * curl 'https://api.pixiv.moe/v1/favourite/46453302' \
   * -X PUT \
   * -H 'access-token: AAA' \
   * -H 'content-type: application/json' \
   * -H 'accept: application/json'
   *
   * @param illustId illust Id
   * @return favourite response result
   */
  @PUT("/favourite/{illust_id}")
  Observable<CommonResponseData> addFavourite(@Path("illust_id") int illustId);

  /**
   * Auth
   * {
   * "username":"[:username]",
   * "password":"[:password]"
   * }
   * example
   * curl 'https://api.pixiv.moe/v1/user/auth' \
   * -H 'content-type: application/json' \
   * -H 'accept: application/json' \
   * --data-binary '{"username":"abc","password":"mypassword"}'
   *
   * @return AuthData
   */
  @POST("user/auth")
  Observable<AuthData> auth();
}
