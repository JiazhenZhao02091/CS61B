package Course.course5.course5_3;

/**
 * @author JiazhenZhao
 * 2024/2/2
 * 类说明：
 */
public class ArrayMap<K, V> implements Map61B<K, V>{
    public K[] keys;
    public V[] values;
    public int size; // the size of ArrayMap

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key)
                return i;
        }
        return -1;
    }

    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
        else
            values[index] = value;

    }

    public boolean containsKey(K key, V value) {
        return getKeyIndex(key) != -1;
    }

    public V get(K key) {
        int index = getKeyIndex(key);
        return values[index];
    }

    public K[] keys() {
        K[] keys = (K[]) new Object[size];
        for (int i = 0; i < size; i++)
            keys[i] = this.keys[i];
        return keys;
    }

    public int size() {
        return size;
    }
}
/**
 * TODO:
 *  这里暂时没有考虑 resize 的事情
 *  put(key, value): Associate key with value.
 *  containsKey(key): Checks if map contains the key.
 *  get(key): Returns value, assuming key exists.
 *  keys(): Returns a list of all keys.
 *  size(): Returns number of keys.
 */