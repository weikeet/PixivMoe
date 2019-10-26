package me.weicools.pixivmoe.lib.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import me.weicools.pixivmoe.lib.integration.IRepositoryManager

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc: repositoryManager 用于管理网络请求层, 以及数据缓存层
 */
@Suppress("unused")
open class BaseModel(var repositoryManager: IRepositoryManager?) : IModel, LifecycleObserver {
  /**
   * [BasePresenter.onDetach] 默认调用 [IModel.onDetach]
   */
  override fun onDetach() {
    repositoryManager = null
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  internal fun onDestroy(owner: LifecycleOwner) {
    owner.lifecycle.removeObserver(this)
  }
}