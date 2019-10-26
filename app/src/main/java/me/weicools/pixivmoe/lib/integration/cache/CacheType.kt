package me.weicools.pixivmoe.lib.integration.cache

import android.app.ActivityManager
import android.content.Context
import me.weicools.pixivmoe.lib.integration.RepositoryManager

/**
 * @author Weicools Create on 2019.10.22
 *
 * desc:
 */
interface CacheType {
  companion object {
    const val RETROFIT_SERVICE_CACHE_TYPE_ID = 0
    const val CACHE_SERVICE_CACHE_TYPE_ID = 1
    const val EXTRAS_TYPE_ID = 2
    const val ACTIVITY_CACHE_TYPE_ID = 3
    const val FRAGMENT_CACHE_TYPE_ID = 4

    /**
     * [RepositoryManager] 中存储 Retrofit Service 的容器
     */
    val RETROFIT_SERVICE_CACHE: CacheType = object : CommonCacheType() {
      override fun getMaxSize(): Int {
        return 150
      }

      override fun getMaxSizeMultiplier(): Float {
        return 0.002f
      }

      override fun getCacheTypeId(): Int {
        return RETROFIT_SERVICE_CACHE_TYPE_ID
      }
    }

    /**
     * [RepositoryManager]中储存 Cache Service 的容器
     */
    val CACHE_SERVICE_CACHE: CacheType = object : CommonCacheType() {
      override fun getMaxSize(): Int {
        return 150
      }

      override fun getMaxSizeMultiplier(): Float {
        return 0.002f
      }

      override fun getCacheTypeId(): Int {
        return CACHE_SERVICE_CACHE_TYPE_ID
      }
    }

    /**
     * [AppComponent] 中的 extras
     */
    val EXTRAS: CacheType = object : CommonCacheType() {
      override fun getMaxSize(): Int {
        return 500
      }

      override fun getMaxSizeMultiplier(): Float {
        return 0.005f
      }

      override fun getCacheTypeId(): Int {
        return EXTRAS_TYPE_ID
      }
    }

    /**
     * [Activity] 中存储数据的容器
     */
    val ACTIVITY_CACHE: CacheType = object : CommonCacheType() {
      override fun getMaxSize(): Int {
        return 80
      }

      override fun getMaxSizeMultiplier(): Float {
        return 0.0008f
      }

      override fun getCacheTypeId(): Int {
        return ACTIVITY_CACHE_TYPE_ID
      }
    }

    /**
     * [Fragment] 中存储数据的容器
     */
    val FRAGMENT_CACHE = object : CommonCacheType() {
      override fun getMaxSize(): Int {
        return 80
      }

      override fun getMaxSizeMultiplier(): Float {
        return 0.0008f
      }

      override fun getCacheTypeId(): Int {
        return FRAGMENT_CACHE_TYPE_ID
      }
    }
  }

  abstract class CommonCacheType : CacheType {
    override fun calculateCacheSize(context: Context): Int {
      val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
      val targetMemoryCacheSize = (activityManager.memoryClass * getMaxSizeMultiplier() * 1024f).toInt()

      return if (targetMemoryCacheSize >= getMaxSize()) {
        getMaxSize()
      } else targetMemoryCacheSize
    }

    abstract fun getMaxSize(): Int

    abstract fun getMaxSizeMultiplier(): Float
  }

  fun getCacheTypeId(): Int

  fun calculateCacheSize(context: Context): Int
}