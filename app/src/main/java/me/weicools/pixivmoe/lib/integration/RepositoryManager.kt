package me.weicools.pixivmoe.lib.integration

import android.content.Context

/**
 * @author Weicools Create on 2019.10.22
 *
 * desc:
 */
class RepositoryManager:IRepositoryManager {
  override fun <T> obtainRetrofitService(service: Class<T>): T {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun <T> obtainCacheService(cache: Class<T>): T {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun clearAllCache() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getContext(): Context {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setObtainServiceDelegate(delegate: IRepositoryManager.ObtainServiceDelegate) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}