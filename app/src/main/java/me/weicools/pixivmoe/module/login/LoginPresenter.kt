package me.weicools.pixivmoe.module.login

import me.weicools.pixivmoe.lib.mvp.BasePresenter

/**
 * @author Weicools Create on 2019.10.21
 *
 * desc:
 */
class LoginPresenter constructor(model: LoginContract.Model, view: LoginContract.View) : BasePresenter<LoginContract.Model, LoginContract.View>(model, view) {

  override fun onAttach() {
    super.onAttach()
  }

  override fun onDetach() {
    super.onDetach()
  }
}
