package me.weicools.pixivmoe.lib.integration

import android.app.Activity
import android.app.Application
import android.os.Bundle
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Weicools Create on 2019.10.23
 *
 * desc:
 */

@Singleton
class ActivityLifecycle @Inject constructor():Application.ActivityLifecycleCallbacks {
  // @Inject
  // lateinit var app

  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onActivityStarted(activity: Activity) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onActivityResumed(activity: Activity) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onActivityPaused(activity: Activity) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onActivityStopped(activity: Activity) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onActivityDestroyed(activity: Activity) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}