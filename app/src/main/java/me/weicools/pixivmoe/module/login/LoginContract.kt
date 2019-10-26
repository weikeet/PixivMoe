package me.weicools.pixivmoe.module.login

import android.app.Activity
import io.reactivex.Observable
import me.weicools.pixivmoe.data.User
import me.weicools.pixivmoe.lib.mvp.IModel
import me.weicools.pixivmoe.lib.mvp.IView

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc:
 */
interface LoginContract {
  //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
  interface View : IView {
    val activity: Activity
    // 申请权限
    // val rxPermissions: RxPermissions

    fun startLoadMore()
    fun endLoadMore()
  }

  //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
  interface Model : IModel {
    fun getUsers(lastIdQueried: Int, update: Boolean): Observable<List<User>>
  }
}