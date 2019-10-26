package me.weicools.pixivmoe.lib.mvp

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc: 每个 Model 都需要实现此类
 */
interface IModel {
  /**
   * 在框架中 {@link BasePresenter#onDetach()} 时会默认调用 {@link IModel#onDetach()}
   */
  fun onDetach()
}