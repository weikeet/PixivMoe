package com.weiwei.android.pixiv.api;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by weicools on 2018.07.10
 *
 * desc:
 */
public final class PixivMoeClient {
  private final PixivMoeApi mMoeApi;

  private PixivMoeClient() {
    OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(PixivMoeApi.BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build();

    mMoeApi = retrofit.create(PixivMoeApi.class);
  }

  private static class PixivMoeHolder {
    static final PixivMoeClient INSTANCE = new PixivMoeClient();
  }

  public static PixivMoeClient get() {
    return PixivMoeHolder.INSTANCE;
  }

  public PixivMoeApi getMoeApi() {
    return mMoeApi;
  }
}
