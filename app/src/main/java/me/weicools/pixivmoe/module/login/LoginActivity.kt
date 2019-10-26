package me.weicools.pixivmoe.module.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.weicools.pixiv.moe.R
import me.weicools.pixivmoe.lib.mvp.IView

class LoginActivity : AppCompatActivity(),IView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
  }
}
