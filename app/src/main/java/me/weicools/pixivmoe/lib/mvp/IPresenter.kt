package me.weicools.pixivmoe.lib.mvp

import android.app.Activity

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc: 每个 Presenter 都需要实现此类
 */
interface IPresenter {
  /**
   * 做一些初始化操作
   */
  fun onAttach() {}

  /**
   * [Activity.onDestroy] 时会默认调用 [IPresenter.onDetach]
   */
  fun onDetach() {}
}