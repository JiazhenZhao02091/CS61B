package Project.project1B;
/**
 * @author JiazhenZhao
 * 2024/2/1
 */

import Project.project1A.LinkNode;

/**
 * Progress 2 Circle sentinel
 * 使用循环哨兵指针可以减少哨兵的数量
 * 同时可以减少代码长度以及提升运行速度
 */
public class LinkedListDeque<T> implements Deque<T> {
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
     */
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

    @Override
    public void resize(int capacity) {

    }

    /***
     * 在队列头添加 item
     * @param item
     */
    @Override
    public void addFirst(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null, null);
        tmp.next = sentinel.next;
        tmp.prev = sentinel;
        sentinel.next = tmp;
        size++;
    }

    /***
     * 在队列尾添加 item
     * @param item
     */
    @Override
    public void addLast(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null, null);
        tmp.prev = sentinel.prev;
        sentinel.prev.next = tmp;
        tmp.next = sentinel;
        sentinel.prev = tmp;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LinkNode tmp = sentinel.next;
        while (tmp != null) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
            if (tmp == sentinel)
                break;
        }
        System.out.println();
    }

    @Override
    public void checkFEBount() {

    }

    @Override
    public T removeFirst() {
        if (size == 0)
            return null;
        T tmp = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return tmp;
    }

    @Override
    public T removeLast() {
        if (size == 0)
            return null;
        T tmp = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return tmp;
    }

    @Override
    public T get(int index) {
        if (index >= size)
            return null;
        LinkNode tmp = sentinel.next;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }
        return (T) tmp.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size)
            return null;
        return this.get(index);
    }


    @Override
    public void print() {
        LinkNode tmp = sentinel.next;
        while (tmp != null) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
            if (tmp == sentinel)
                break;
        }
        System.out.println();
    }
}
