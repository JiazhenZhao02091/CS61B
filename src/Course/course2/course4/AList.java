package Course.course2.course4;

import static org.junit.Assert.assertEquals;

/**
 * @author JiazhenZhao
 * 2024/1/17
 * 类说明：
 */
public class AList<Item> {
    private Item[] items;
    private int size;

    /** 重置数组 */
    public void Resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size == items.length)
            Resize(size * 2);
        items[size] = x;
        size ++;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
        items[size] = null;
        size --;
        return items[size];
    }

    /** dynamic change the Array size */
    public void dy_resize(){
        float ratio = (float) size / items.length;
        if(ratio < 0.25)
            Resize(items.length / 2);
    }
}
