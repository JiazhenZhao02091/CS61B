package Project.project1A;


/**
 * @author JiazhenZhao
 * 2024/1/20
 * 类说明：
 * *    add 和 remove 操作不得涉及任何循环或递归。
 * 单个此类操作必须花费“恒定时间”，即执行时间不应 取决于双端队列的大小。
 * *    get必须使用迭代，而不是递归
 * *    size必须花费恒定的时间
 */
/** Progress 1
 *  为了避免出现前后空指针的情况，因此可以使用一个固定存在的哨兵节点
 *  同时，为了实现队列的前后增删，可以使用两个哨兵
 * */
public class LinkedListDeque<T> {
    private LinkNode sentFront; // front 哨兵节点
    private LinkNode sentBack;  // back 哨兵节点
    private LinkNode first;    // first of the linkDeque.
    private LinkNode end;      // end of the linkDeque
    private int size;          // queue size.

    public LinkedListDeque() {
        size = 0;
        LinkNode n = new LinkNode(63, null, null);
        sentFront = n;
        LinkNode m = new LinkNode(63, null, null);
        sentBack = m;
    }
    /**
     * 使用一个参数创建 LinkListDeque
     * */
    public LinkedListDeque(T item) {
        // Make Sentinel Node.
        LinkNode n = new LinkNode(63, null, null);
        sentFront = n;
        LinkNode m = new LinkNode(63, null, null);
        sentBack = m;
        // Make Data Node .
        LinkNode<T> node = new LinkNode<>(item, sentBack, sentFront);
        sentFront.next = node;
        sentBack.prev = node;
        size = 1;

    }

    /***
     * 在队列头添加 item
     * @param item
     */
    public void addFirst(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null,sentFront);
        tmp.next = sentFront.next;
        sentFront.next = tmp;
        size++;
    }

    /***
     * 在队列尾添加 item
     * @param item
     */
    public void addLast(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, sentBack,sentBack.prev);
        sentBack.prev.next = tmp;
        sentBack.prev = tmp;
        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode tmp = sentFront.next;
        while(tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
            if(tmp == sentBack || tmp == sentFront)
                break;
        }
        System.out.println();
    }

    public T removeFirst() {
        T tmp = (T) sentFront.next.item;
        sentFront.next = sentFront.next.next;
        size --;
        return tmp;
    }

    public T removeLast() {
        T tmp = (T) sentBack.prev.item;
        sentBack.prev.prev.next = sentBack;
        sentBack.prev = sentBack.prev.prev;
        size --;
        return tmp;
    }

    public T get(int index) {
        if(index >= size)
            return null;
        LinkNode tmp = sentFront.next;
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
        LinkNode tmp = sentFront.next;
        while(tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
            if(tmp == sentBack || tmp == sentFront)
                break;
        }
        System.out.println();
    }
}
