package Project.project1A;
/**
 * @author JiazhenZhao
 * 2024/1/20
 * *    add 和 remove 操作不得涉及任何循环或递归。
 * 单个此类操作必须花费“恒定时间”，即执行时间不应 取决于双端队列的大小。
 * *    get必须使用迭代，而不是递归
 * *    size必须花费恒定的时间
 */

/** Progress 1 Sentinel and Two sentinel
 *  为了避免出现前后空指针的情况，因此可以使用一个固定存在的哨兵节点
 *  同时，为了实现队列的前后增删，可以使用两个哨兵
 */

/** Progress 2 Circle sentinel
 * 使用循环哨兵指针可以减少哨兵的数量
 * 同时可以减少代码长度以及提升运行速度
 */
public class LinkedListDeque<T> {
    private LinkNode sentinel;  // sentinel 哨兵节点
    private int size;           // queue size.

    public LinkedListDeque() {
        size = 0;
        LinkNode n = new LinkNode(63, null, null);
        n.next = n;
        n.prev = n;
        sentinel = n;
    }
    /**
     * 使用一个参数创建 LinkListDeque
     * */
    public LinkedListDeque(T item) {
        // Make Sentinel Node.
        LinkNode n = new LinkNode(63, null, null);
        n.next = n.prev;
        n.prev = n;
        sentinel = n;
        // Make Data Node .
        LinkNode<T> node = new LinkNode<>(item, null, null);
        node.prev = sentinel;
        node.next = sentinel;
        sentinel.prev = node;
        sentinel.next = node; // circle
        size = 1;

    }

    /***
     * 在队列头添加 item
     * @param item
     */
    public void addFirst(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null,null);
        tmp.next = sentinel.next;
        tmp.prev = sentinel;
        sentinel.next = tmp;
        size++;
    }

    /***
     * 在队列尾添加 item
     * @param item
     */
    public void addLast(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null, null);
        tmp.prev = sentinel.prev;
        sentinel.prev.next = tmp;
        tmp.next = sentinel;
        sentinel.prev = tmp;
        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode tmp = sentinel.next;
        while(tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
            if(tmp == sentinel)
                break;
        }
        System.out.println();
    }

    public T removeFirst() {
        if(size == 0)
            return null;
        T tmp = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return tmp;
    }

    public T removeLast() {
        if(size == 0)
            return null;
        T tmp = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return tmp;
    }

    public T get(int index) {
        if(index >= size)
            return null;
        LinkNode tmp = sentinel.next;
        while(index > 0) {
            tmp = tmp.next;
            index --;
        }
        return (T) tmp.item;
    }

    public T getRecursive(int index) {
        if(index < 0 || index > size)
            return null;
        return this.get(index);
    }



    public void print(){
        LinkNode tmp = sentinel.next;
        while(tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
            if(tmp == sentinel)
                break;
        }
        System.out.println();
    }
}
