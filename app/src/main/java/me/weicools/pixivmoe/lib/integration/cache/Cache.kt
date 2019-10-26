package me.weicools.pixivmoe.lib.integration.cache

/**
 * @author Weicools Create on 2019.10.22
 *
 * desc:
 */
interface Cache<K, V> {
  interface Factory {
    /**
     * Returns a new cache
     *
     * @param [cacheType] 框架中需要缓存的模块类型
     */
    fun build(cacheType: CacheType): Cache<*, *>
  }

  /**
   * 返回当前缓存已占用的总 size
   */
  fun size(): Int

  /**
   * 返回当前缓存所能允许的最大 size
   */
  fun getMaxSize(): Int

  /**
   * 返回 缓存中 [key] 对应的 value
   */
  fun get(key: K): V?

  /**
   * 加入缓存，已存在则会被替换
   * 如果这个 [key] 在容器中已经储存有 [value], 则返回旧的 [value] 否则返回 null
   */
  fun put(key: K, value: V): V?

  /**
   * 移除[key] 对应的缓存
   * [key] 存在对应缓存value 则会删除并对应value 否则返回 null
   */
  fun remove(key: K): V?

  /**
   * @return true 为在容器中含有这个[key], 否则为 false
   */
  fun containsKey(key: K): Boolean

  /**
   * 返回当前缓存中所有 key
   */
  fun keySet(): MutableSet<K>

  /**
   * 清除缓存中所有的内容
   */
  fun clear()
}