package me.weicools.pixivmoe.lib.integration.cache

import kotlin.math.roundToInt

/**
 * @author Weicools Create on 2019.10.22
 *
 * desc:
 */
class LruCache<K, V>(size: Int) : Cache<K, V> {

  private val cache = LinkedHashMap<K, V>(100, 0.75f, true)
  private var initialMaxSize: Int = size
  private var maxSize: Int = 0
  private var currentSize = 0

  @Synchronized
  fun setSizeMultiplier(multiplier: Float) {
    require(multiplier >= 0) { "Multiplier must be >= 0" }
    maxSize = (initialMaxSize * multiplier).roundToInt()
    evict()
  }

  /**
   * 当缓存中已占用的总 size 大于允许的最大 size ,会使用  [trimToSize] 开始清除满足条件的条目
   */
  private fun evict() {
    trimToSize(maxSize)
  }

  /**
   * 当指定的 size 小于当前缓存已占用的总 size 时,会开始清除缓存中最近最少使用的条目
   */
  @Synchronized
  fun trimToSize(size: Int) {
    var last: Map.Entry<K, V>
    while (currentSize > size) {
      last = cache.entries.iterator().next()
      val toRemove = last.value
      currentSize -= getItemSize(toRemove)
      val key = last.key
      cache.remove(key)
      onItemEvicted(key, toRemove)
    }
  }

  /**
   * 当缓存中有item被移除时, 会回调此方法, 默认空实现, 子类可以重写这个方法
   */
  fun onItemEvicted(key: K, value: V) {}

  /**
   * 返回每个item 所占用的 size, 默认为1, 这个 size 的单位必须和构造函数所传入的 size 一致
   * 子类可以重写这个方法以适应不同的单位,比如说 bytes
   */
  fun getItemSize(item: V): Int {
    return 1
  }

  /**
   * 返回当前缓存已占用的总 size
   */
  @Synchronized
  override fun size(): Int {
    return currentSize
  }

  /**
   * 返回当前缓存所能允许的最大 size
   */
  @Synchronized
  override fun getMaxSize(): Int {
    return maxSize
  }

  /**
   * 返回这个[key] 在缓存中对应的value, 如果返回null 说明这个[key] 没有对应的value
   */
  @Synchronized
  override fun get(key: K): V? {
    return cache[key]
  }

  /**
   * 将[key] 和[value] 以条目的形式加入缓存, 如果这个[key] 在缓存中已经有对应的value
   * 则此value 被新的[value] 替换并返回,如果为null 说明是一个新条目
   */
  @Synchronized
  override fun put(key: K, value: V): V? {
    val itemSize = getItemSize(value)
    if (itemSize >= maxSize) {
      onItemEvicted(key, value)
      return null
    }

    val result = cache.put(key, value)
    if (value != null) {
      currentSize += itemSize
    }
    if (result != null) {
      currentSize - +getItemSize(result)
    }
    evict()

    return result
  }

  /**
   * 如果这个[key] 在容器中已经储存有value 并且删除成功则返回删除的[key], 否则返回 null
   */
  @Synchronized
  override fun remove(key: K): V? {
    val value = cache.remove(key)
    if (value != null) {
      currentSize -= getItemSize(value)
    }
    return value
  }

  /**
   * 如果这个[key] 在缓存中有对应的value 并且不为null, 则返回 true
   */
  @Synchronized
  override fun containsKey(key: K): Boolean {
    return cache.containsKey(key)
  }

  /**
   * 返回当前缓存中含有的所有key
   */
  @Synchronized
  override fun keySet(): MutableSet<K> {
    return cache.keys
  }

  override fun clear() {
    trimToSize(0)
  }
}