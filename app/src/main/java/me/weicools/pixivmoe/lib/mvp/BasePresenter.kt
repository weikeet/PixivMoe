package me.weicools.pixivmoe.lib.mvp

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * @author Weicools Create on 2019.10.21
 *
 * desc:
 */
@Suppress("unused")
open class BasePresenter<M : IModel, V : IView> : IPresenter, LifecycleObserver {
  val tag = this.javaClass.simpleName

  var model: M? = null
  var view: V? = null
  var compositeDisposable: CompositeDisposable? = null

  constructor(model: M?, view: V?) {
    this.model = model
    this.view = view

    onAttach()
  }

  constructor(view: V) : this(null, view)

  constructor() : this(null, null)

  final override fun onAttach() {
    if (view is LifecycleOwner) {
      (view as LifecycleOwner).lifecycle.addObserver(this)

      if (model is LifecycleObserver) {
        (view as LifecycleOwner).lifecycle.addObserver(model as LifecycleObserver)
      }
    }

    if (useEventBus()) {
    }
  }

  override fun onDetach() {
    if (useEventBus()) {
    }

    // 停止集合中正在执行的 RxJava 任务
    // 保证 Activity 结束时取消所有正在执行的订阅
    compositeDisposable?.clear()

    model?.onDetach()
    model = null
    view = null
    compositeDisposable = null
  }

  /**
   * 只有当 [view] 不为 null, 并且 [view] 实现了 [LifecycleObserver] 时, 此方法才会被调用
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  fun onDestroy(owner: LifecycleOwner) {
    owner.lifecycle.removeObserver(this)
  }

  /**
   * 将 [Disposable] 添加到 [CompositeDisposable] 中统一管理
   * 可在 [Activity.onDestroy] 中使用 [.unDispose] 停止正在执行的 RxJava 任务,避免内存泄漏
   * 目前基类已使用 [Lifecycle] 避免内存泄漏,此方法作为备用方案
   *
   * @param disposable
   */
  fun addDispose(disposable: Disposable) {
    if (compositeDisposable == null) {
      compositeDisposable = CompositeDisposable()
    }
    // 将所有 Disposable 放入容器集中处理
    compositeDisposable?.add(disposable)
  }

  /**
   * 是否使用 EventBus
   *
   * @return 返回 [true] 默认为使用 [code true] 自动注册 EventBus
   */
  fun useEventBus(): Boolean {
    return true
  }
}