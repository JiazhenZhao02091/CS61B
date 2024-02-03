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
 */
public class ArraySet<T> implements Iterable<T>{
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
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }

    public String toString(){
        String string = "";
        for(int i = 0 ; i < size; i ++){
            string += items[i];
        }
        return string;
    }

    public boolean equals(ArraySet<T> x){
        if(size < x.size())
            return false;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
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
