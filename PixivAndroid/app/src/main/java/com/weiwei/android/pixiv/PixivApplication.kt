package com.weiwei.android.pixiv

import android.app.Application
import timber.log.Timber

/**
 * @author weicools Create on 2018.07.11
 */
class PixivApplication : Application() {
  private companion object {
    const val TAG = "PixivApplication"
  }

  override fun onCreate() {
    super.onCreate()

    Timber.tag(TAG).d("onCreate: ")
  }
}
