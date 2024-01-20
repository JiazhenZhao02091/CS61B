package Project.project1A;

import Project.project0.In;
import Project.project0.Planet;

/**
 * @author JiazhenZhao
 * 2024/1/20
 * 类说明：
 * *    add 和 remove 操作不得涉及任何循环或递归。
 * 单个此类操作必须花费“恒定时间”，即执行时间不应 取决于双端队列的大小。
 * *    get必须使用迭代，而不是递归
 * *    size必须花费恒定的时间
 */
public class LinkedListDeque<T> {
    private LinkNode first;  // first of the linkDeque.
    private LinkNode end;    // end of the linkDeque
    private int size;        // queue size.

    public LinkedListDeque() {

    }
    /**
     * 使用一个参数创建 LinkListDeque
     * */
    public LinkedListDeque(T item) {
        LinkNode<T> LinkList = new LinkNode<>(item, null,null);
        first = LinkList;
        LinkList.prev = end;
        end = LinkList;
        size = 1;
    }

    /***
     * 在队列头添加 item
     * @param item
     */
    public void addFirst(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null,null);
        tmp.next = first;
        first = tmp;
        size++;
    }

    /***
     * 在队列尾添加 item
     * @param item
     */
    public void addLast(T item) {
        LinkNode<T> tmp = new LinkNode<>(item, null,null);
        tmp.prev = end;
        end.next = tmp;
        end = tmp;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode tmp = first;
        while(tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if(first == null)
            return  null;
        T tmp = (T) first.item;
        first = first.next;
        size --;
        return tmp;
    }

    public T removeLast() {
        if(end == null)
            return  null;
        T tmp = (T) end.item;
        end = end.prev;
        end.next = null;
        size --;
        return tmp;
    }

    public T get(int index) {
        if(index >= size)
            return null;
        LinkNode tmp = first;
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
        LinkNode tmp = first;
        while(tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
