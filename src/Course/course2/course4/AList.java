package Course.course2.course4;
/**
 * @author JiazhenZhao
 * 2024/1/17
 * 类说明：
 */
public class AList {
    private int[] items;
    private int size;

    /** 重置数组 */
    public void Resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size == items.length)
            Resize(size * 2);
        items[size] = x;
        size ++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i - 1];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
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
