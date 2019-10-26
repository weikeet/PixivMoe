package me.weicools.pixivmoe.lib.mvp

import android.content.Intent

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc:
 */
interface IView {
  fun showLoading() {}

  fun hideLoading() {}

  fun showMessage(message: String) {}

  fun launchActivity(intent: Intent) {}

  fun killMyself() {}
}