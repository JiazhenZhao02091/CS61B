package Project.project1.project1A;

/**
 * @author JiazhenZhao
 * 2024/1/20
 * 类说明：
 */
public class LinkNode<T> {
    public T item;
    public LinkNode next;
    public LinkNode prev;

    public LinkNode(T item, LinkNode next) {
        this.item = item;
        this.next = next;
    }

    public LinkNode(T item, LinkNode next, LinkNode prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public LinkNode getPrev() {
        return prev;
    }

    public void setPrev(LinkNode prev) {
        this.prev = prev;
    }

    public LinkNode() {

    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
