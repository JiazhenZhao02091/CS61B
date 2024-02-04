package Course.course6;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author JiazhenZhao
 * 2024/2/3
 * 类说明：
 * Set : 无序不重复列表
 * Map : Key value 列表
 * Iterable（可迭代对象） 提供 Iterator
 * Iterator（迭代器）提供 hasNext() 和 next() 方法
 * 以上两者都是接口，提供了一种必要的约束和实现
 */
public class ArraySet<T> implements Iterable<T> {
    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }
    public T[] items;
    public int size;


    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    private int getSetIndex(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i] == x)
                return i;
        }
        return -1;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        int index = getSetIndex(x);
        return index != -1;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        int index = getSetIndex(x);
        if (index != -1)
            items[index] = x;
        else {
            items[size] = x;
            size++;
        }
        return;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
    }

    public String toString() {
        String string = "{";
        for (int i = 0; i < size; i++) {
            string += "," + items[i];
        }
        string += "}";
        return string;
        /**
         * String 实际上每次都是创建新的字符串
         * 为了更高效可以使用 StringBuilder
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
        */
    }

    /**
     * 在 primitive 类型中 '==' 比较盒子里面的值，在 objects '==' 比较地址是否相同
     * equals must follow below:
     * 1.) equals must be an equivalence relation
     *
     *  1)
     *      reflexive: x.equals(x) is true
     *      symmetric: x.equals(y) if and only if y.equals(x)
     *      transitive: x.equals(y) and y.equals(z) implies x.equals(z)
     *  2.) It must take an Object argument, in order to override the original .equals() method
     *  3.) It must be consistent if x.equals(y), then as long as x and y remain unchanged: x must continue to equal y
     *  4.) It is never true for null x.equals(null) must be false
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }


    /*
    TODO:
        1. Make ArraySet implement the Iterable<T> interface.
        2. Implement a toString method.
        3. Implement an equals() method.
    */
}
