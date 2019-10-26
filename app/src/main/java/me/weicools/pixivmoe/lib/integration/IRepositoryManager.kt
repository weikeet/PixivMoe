package me.weicools.pixivmoe.lib.integration

import android.content.Context
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import retrofit2.Retrofit

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc:
 */
interface IRepositoryManager {
  /**
   * 根据传入的 Class 获取对应的 Retrofit service
   *
   * @param [service] Retrofit service class
   * @param [T]     Retrofit service 类型
   **/
  @NonNull
  fun <T> obtainRetrofitService(@NonNull service: Class<T>): T

  @NonNull
  fun <T> obtainCacheService(@NonNull cache: Class<T>): T

  /**
   * 清理所有缓存
   */
  fun clearAllCache()

  /**
   * 获取 [Context]
   */
  @NonNull
  fun getContext(): Context

  /**
   * 设置一个可以委托创建服务的接口
   *
   * @param delegate 委托接口，可为空
   */
  fun setObtainServiceDelegate(@Nullable delegate: ObtainServiceDelegate)

  interface ObtainServiceDelegate {
    @Nullable
    fun <T> createRetrofitService(retrofit: Retrofit, serviceClass: Class<T>): T
  }
}