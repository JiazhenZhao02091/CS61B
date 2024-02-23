package Lab.lab8.src.hashmap;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.*;

/**
 * A hash table-backed Map implementation. Provides amortized constant time
 * access to elements via get(), remove(), and put() in the best case.
 * <p>
 * Assumes null keys will never be inserted, and does not resize down upon remove().
 *
 * @author JiazhenZhao
 */
public class MyHashMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    public class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }

        Node(K k) {
            key = k;
            value = null;
        }
    }

    /* Instance Variables */
    /**
     * 每个 buckets 是存储一系列节点的集合
     * Collection  相当于是一个共同的父类
     * 使用Java中多态的性质来实现，一个静态 Collection 类型对应不同的实现类型（LinkedList, ArrayList)
     * eg：LinkedList<Node>[] , 一个存储 Node 的列表
     */

    private Collection<Node>[] buckets;
    private int[] buckets_size;
    // You should probably define some more!
    private int initialCapacity;
    private double loadFactor;
    private int size;


    /**
     * Constructors
     */
    public MyHashMap() {
        this.initialCapacity = 16;
        this.loadFactor = 0.75;
        buckets = createTable(initialCapacity);
        buckets_size = new int[initialCapacity];
        size = 0;
    }

    public MyHashMap(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.loadFactor = 0.75;
        buckets = createTable(initialCapacity);
        buckets_size = new int[initialCapacity];
        size = 0;
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor      maximum load factor
     */
    public MyHashMap(int initialCapacity, double loadFactor) {
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        buckets = createTable(initialCapacity);
        buckets_size = new int[initialCapacity];
        size = 0;
    }

    public void check() {
        if ((double) size / initialCapacity <= loadFactor)
            return;
        // 暂存数据
        LinkedList<Node> tmp_list = new LinkedList<>();

        for (int i = 0; i < initialCapacity; i++) {
            if (buckets[i] != null)
                for (Node n : buckets[i])
                    tmp_list.add(n);
        }
        // Need resize .
        initialCapacity = initialCapacity * 2;
        // 清除所有的数据 此时更新的 bucket 的 size 是新的 size
        clear();
        // 插入数据
        for (Node node : tmp_list)
            put(node.key, node.value);
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        Node node = new Node(key, value);
        Node finded_node = findNode(node);
        if (finded_node != null) {
            finded_node.value = node.value;
            return node;
        }

        int hash_index = key.hashCode();
        int index = Math.floorMod(hash_index, initialCapacity);
        if (buckets_size[index] == 0) {
            buckets[index] = createBucket();
            buckets[index].add(node);
            buckets_size[index]++;
        } else {
            buckets[index].add(node);
        }
        size++;
        check(); // 检查 loadFactor
        return node;
    }

    public Node findNode(Node node) {
        int hash_index = node.key.hashCode();
        hash_index = Math.floorMod(hash_index, initialCapacity);
        if (buckets[hash_index] == null)
            return null;
        for (Node n : buckets[hash_index]) {
            if (n.key.compareTo(node.key) == 0)
                return n;
        }
        return null;
    }

    /**
     * Returns a data structure to be a hash table bucket
     * <p>
     * The only requirements of a hash table bucket are that we can:
     * 1. Insert items (`add` method)
     * 2. Remove items (`remove` method)
     * 3. Iterate through items (`iterator` method)
     * <p>
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     * <p>
     * Override this method to use different data structures as
     * the underlying bucket type
     * <p>
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     * <p>
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return new Collection[tableSize];
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

    @Override
    public void put(K key, V value) {
        Node node = createNode(key, value);
    }

    @Override
    public V get(K key) {
        Node node = findNode(new Node(key));
        return node == null ? null : node.value;
    }

    @Override
    public boolean containsKey(K key) {
        Node node = findNode(new Node(key));
        return node == null ? false : true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        buckets = createTable(initialCapacity);
        buckets_size = new int[initialCapacity];
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    private class MyHashMapIterator<K> implements Iterator<K>{

        private int position;
        @Override
        public boolean hasNext() {
            //TODO:
            // 这里直接使用了 size，但是 size 记录的是所有的元素数量，
            // 而不是 hashtable 中下标的数量
            return position < size;
        }

        @Override
        public K next() {
            K key = null;
            for(Node n : buckets[position])
                key = (K) n.key;
            position ++;
            return key;
        }
    }


    @Override
    public Iterator<K> iterator() {
        return new MyHashMapIterator<>();
    }

    public void printHashMap() {
        for (int i = 0; i < initialCapacity; i++) {
            if (buckets[i] != null)
                for (Node n : buckets[i])
                    System.out.println("i = " + i + " key = " + n.key + "  value = " + n.value);
        }
    }
}
