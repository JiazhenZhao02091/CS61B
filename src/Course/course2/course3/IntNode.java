package Course.course2.course3;

/**
 * @author JiazhenZhao
 * 2024/1/15
 * 类说明：
 */
public class IntNode {
    public int item;
    public IntNode next;
    public IntNode prev;

    public IntNode(int item, IntNode next) {
        this.item = item;
        this.next = next;
    }

    public IntNode(int item, IntNode next, IntNode prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
