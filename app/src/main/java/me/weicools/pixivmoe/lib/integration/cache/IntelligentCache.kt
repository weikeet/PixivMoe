package me.weicools.pixivmoe.lib.integration.cache

/**
 * @author Weicools Create on 2019.10.22
 *
 * desc:
 */
class IntelligentCache<V>(size: Int) : Cache<String, V> {
  companion object {
    const val KEY_KEEP = "Keep="

    /**
     * 使用此方法返回的值作为 key, 可以将数据永久存储至内存中
     */
    fun getKeyOfKeep(key: String): String {
      return KEY_KEEP + key
    }
  }

  private var map: MutableMap<String, V> = HashMap(size)
  private var cache: Cache<String, V> = LruCache(size)

  constructor() : this(8)

  override fun size(): Int {
    return map.size + cache.size()
  }

  override fun getMaxSize(): Int {
    return map.size + cache.getMaxSize()
  }

  override fun get(key: String): V? {
    return if (key.startsWith(KEY_KEEP)) {
      map[key]
    } else cache.get(key)
  }

  override fun put(key: String, value: V): V? {
    return if (key.startsWith(KEY_KEEP)) {
      map.put(key, value)
    } else cache.put(key, value)
  }

  override fun remove(key: String): V? {
    return if (key.startsWith(KEY_KEEP)) {
      map.remove(key)
    } else cache.remove(key)
  }

  override fun containsKey(key: String): Boolean {
    return if (key.startsWith(KEY_KEEP)) {
      map.containsKey(key)
    } else cache.containsKey(key)
  }

  override fun keySet(): MutableSet<String> {
    val set = cache.keySet()
    set.addAll(map.keys)
    return set
  }

  override fun clear() {
    map.clear()
    cache.clear()
  }
}
