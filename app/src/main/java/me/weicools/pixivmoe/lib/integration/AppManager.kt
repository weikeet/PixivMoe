package me.weicools.pixivmoe.lib.integration

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import timber.log.Timber
import java.util.*

/**
 * @author Weicools Create on 2019.10.23
 *
 * desc:
 */
@SuppressLint("StaticFieldLeak")
object AppManager {
  val IS_NOT_ADD_ACTIVITY_LIST = "is_not_add_activity_list"

  val TAG = this.javaClass.simpleName

  var application: Application? = null
  var activityList: List<Activity>? = null
    get() {
      if (field == null) {
        activityList = LinkedList()
      }
      return field
    }
  var currentActivity: Activity? = null

  // val topActivity: Activity?
  //   get() {
  //     if (activityList == null) {
  //       Timber.tag(TAG).w("getTopActivity(): activityList==null")
  //       return null
  //     }
  //     return if (activityList?.isNotEmpty() != false) {
  //       activityList[0]
  //     } else return
  //   }
}