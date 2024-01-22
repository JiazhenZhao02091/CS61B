package Project.project1A;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @author JiazhenZhao
 * 2024/1/20
 * 类说明：
 */
public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int first;
    private int end;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        first = 0;
        end = 1;
    }

    public ArrayDeque(Item[] nums) {
        items = (Item[]) new Object[nums.length * 2];
        System.arraycopy(nums, 0, items, 1, nums.length);
        size = nums.length;
        first = 0;
        end = nums.length + 1;
    }

    public void resize(int capacity) {
        Item[] new_items = (Item[]) new Object[capacity];
        for(int i = 1 ; i <= size ; i ++){
            new_items[i] = this.get(i - 1);
        }
        items = new_items;
        first = 0;
        end = size + 1;
    }

    /*
     TODO: 当整个数组只有一个数值的时候，此时first和end都指向一个位置，此时addFirst()和addLast()会指向同一个位置，
           因此此时如果调用该函数会导致，数组访问冲突。
     Solution : checkFEBount();
    */
    public void addFirst(Item x) {
        if (size >= items.length)
            resize(size * 2);
        items[first] = x;
        first --;
        first = (first + items.length) % items.length;
        size ++;
    }

    public void addLast(Item x) {
        if (size >= items.length)
            resize(size * 2);
        items[end] = x;
        end ++;
        size ++;
    }

    public Item removeFirst() {
        size --;
        Item tmp = items[first];
        first = (first + 1) % items.length;
        checkFEBount();
        return tmp;
    }

    public Item removeLast() {
        size--;
        Item tmp = items[end];
        end = end - 1;
        checkFEBount();
        return tmp;     // 假如只剩一个的时候，first 和 end 会指向同一个点。
    }

    public void print() {
        for (int i = (first + 1) % items.length; i != end; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    public void printDeque() {
        for (int i = (first + 1) % items.length; i != end; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public void checkFEBount(){
        if(first == end)
            end = (first + 1) % items.length;
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        return items[(first + 1 + index) % items.length];
    }

    public boolean isEmpty(){
        return size == 0;
    }



}
