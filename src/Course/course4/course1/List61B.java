package Course.course4.course1;

import java.util.Iterator;

/**
 * @author JiazhenZhao
 * 2024/1/18
 * 类说明：
 */
public interface List61B<Item> {

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Item x);

    /**
     * Returns the item from the back of the list.
     */
    public Item getLast();

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Item get(int i);

    /**
     * Returns the number of items in the list.
     */
    public int size();

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public Item removeLast();

    /**
     * dynamic change the Array size
     */
    public void dy_resize();

    /** Print all members in arrays. */
    default public void print(){
        for(int i = 0 ;i < size() ; i ++){
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
