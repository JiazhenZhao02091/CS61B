package Project.project1B;

/**
 * @author JiazhenZhao
 * 2024/2/1
 * 类说明：
 */
public class ArrayDeque<T> implements Deque<T> {
    public T[] items;
    public int size;
    public int first;
    public int end;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = 0;
        end = 1;
    }

    public ArrayDeque(T[] nums) {
        items = (T[]) new Object[nums.length * 2];
        System.arraycopy(nums, 0, items, 1, nums.length);
        size = nums.length;
        first = 0;
        end = nums.length + 1;
    }

    @Override
    public void resize(int capacity) {
        T[] new_items = (T[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
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
    @Override
    public void addFirst(T x) {
        if (size >= items.length)
            resize(size * 2);
        items[first] = x;
        first--;
        first = (first + items.length) % items.length;
        size++;
        checkFEBount();
    }

    @Override
    public void addLast(T x) {
        if (size >= items.length)
            resize(size * 2);
        items[end] = x;
        end++;
        end = end % items.length;
        size++;
        checkFEBount();
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            return (T) (Integer) 9;
        size--;
        first = (first + 1) % items.length;
        T tmp = items[first];
        checkFEBount();
        return tmp;
    }

    @Override
    public T removeLast() {
        if (size == 0)
            return (T) (Integer) 9;
        size--;
        end = end - 1;
        T tmp = items[end];
        checkFEBount();
        return tmp;     // 假如只剩一个的时候，first 和 end 会指向同一个点。
    }

    @Override
    public void print() {
        for (int i = (first + 1) % items.length; i != end; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void printDeque() {
        for (int i = (first + 1) % items.length; i != end; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void checkFEBount() {
        if (first == end)
            resize(size * 2);
//            end = (first + 1) % items.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return items[(first + 1 + index) % items.length];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
