package me.weicools.pixivmoe.lib.integration.lifecycle

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.android.FragmentEvent
import dagger.Lazy
import io.reactivex.subjects.Subject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Weicools Create on 2019.10.23
 *
 * desc:
 */
@Singleton
class ActivityLifecycleForRxLifecycle @Inject constructor() : Application.ActivityLifecycleCallbacks {

  @Inject
  lateinit var fragmentLifecycle: Lazy<FragmentLifecycleForRxLifecycle>

  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    if (activity is ActivityLifecycleSupport) {
      obtainSubject(activity)?.onNext(ActivityEvent.CREATE)
      if (activity is FragmentActivity) {
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycle.get(), true)
      }
    }
  }

  override fun onActivityStarted(activity: Activity) {
    obtainSubject(activity)?.onNext(ActivityEvent.START)
  }

  override fun onActivityResumed(activity: Activity) {
    obtainSubject(activity)?.onNext(ActivityEvent.RESUME)
  }

  override fun onActivityPaused(activity: Activity) {
    obtainSubject(activity)?.onNext(ActivityEvent.PAUSE)
  }

  override fun onActivityStopped(activity: Activity) {
    obtainSubject(activity)?.onNext(ActivityEvent.STOP)
  }

  override fun onActivityDestroyed(activity: Activity) {
    obtainSubject(activity)?.onNext(ActivityEvent.DESTROY)
  }

  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

  /**
   * 从 [BaseActivity] 中获得桥梁对象 [BehaviorSubject<ActivityEvent> mLifecycleSubject]
   */
  private fun obtainSubject(activity: Activity): Subject<ActivityEvent>? {
    return (activity as? ActivityLifecycleSupport)?.provideLifecycleSubject()
  }
}

@Singleton
class FragmentLifecycleForRxLifecycle @Inject constructor() : FragmentManager.FragmentLifecycleCallbacks() {
  override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
    obtainSubject(f)?.onNext(FragmentEvent.ATTACH)
  }

  override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
    obtainSubject(f)?.onNext(FragmentEvent.CREATE)
  }

  override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
    obtainSubject(f)?.onNext(FragmentEvent.CREATE_VIEW)
  }

  override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.START)
  }

  override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.RESUME)
  }

  override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.PAUSE)
  }

  override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.STOP)
  }

  override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.DESTROY_VIEW)
  }

  override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.DESTROY)
  }

  override fun onFragmentDetached(fm: FragmentManager, f: Fragment) {
    obtainSubject(f)?.onNext(FragmentEvent.DETACH)
  }

  private fun obtainSubject(fragment: Fragment): Subject<FragmentEvent>? {
    return (fragment as? FragmentLifecycleSupport)?.provideLifecycleSubject()
  }
}
