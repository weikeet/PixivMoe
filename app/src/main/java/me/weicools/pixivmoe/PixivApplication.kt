package me.weicools.pixivmoe

import android.app.Application
import cn.cxzheng.tracemanui.MethodTraceServerManager

/**
 * @author weicools Create on 2018.07.11
 *
 * desc:
 */
@Suppress("unused")
class PixivApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    MethodTraceServerManager.startService(this)
  }
}
