package Course.course2.course3;

/**
 * @author JiazhenZhao
 * 2024/1/15
 * 类说明：
 */
public class StufNode<LocsNess> {
    public LocsNess item;
    public StufNode next;
    public StufNode prev;

    public StufNode(LocsNess item, StufNode next) {
        this.item = item;
        this.next = next;
    }

    public StufNode(LocsNess item, StufNode next, StufNode prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public LocsNess getItem() {
        return item;
    }

    public void setItem(LocsNess item) {
        this.item = item;
    }

    public StufNode getNext() {
        return next;
    }

    public void setNext(StufNode next) {
        this.next = next;
    }

    public StufNode getPrev() {
        return prev;
    }

    public void setPrev(StufNode prev) {
        this.prev = prev;
    }
}
