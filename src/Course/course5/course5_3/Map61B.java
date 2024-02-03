package Course.course5.course5_3;

/**
 * @author JiazhenZhao
 * 2024/2/2
 * 类说明：
 */
public interface Map61B<K, V> {
    public int getKeyIndex(K key);

    public void put(K key, V value);

    public boolean containsKey(K key, V value);

    public V get(K key);

    public K[] keys();

    public int size();
}
