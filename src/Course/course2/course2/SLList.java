package Course.course2.course2;

/**
 * @author JiazhenZhao
 * 2024/1/15
 * 类说明：
 */
// sentinel 哨兵节点
public class SLList {

    /*
    private static class IntNode {
        public int item;
        public Course.course2.course2.IntNode next;

        public IntNode(int item, Course.course2.course2.IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    */

    private IntNode sentinel;
    private int size;

    /**
     * Create empty list.
     */
    public SLList(){
        size = 0;
        sentinel = new IntNode(63,null);
    }

    public SLList(int x){
        sentinel = new IntNode(63,null);
        IntNode first = new IntNode(10, null);
        sentinel.next = first;
        size = 1;
    }

    /**
     * return the first item of the list.
     * @return
     */
    public int getFirst(){
        if(sentinel.next == null){
            System.out.println("No first item current.");
            return -1;
        }
        return sentinel.next.item;
    }

    /**
     * get x. item of the list
     * @param x
     * @return
     */
    public IntNode getItem(int x){
        if(x == 0)
            return this.sentinel.next;
        IntNode tmp = this.sentinel.next;
        while(x > 0){
            x --;
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * add x to the front of the list
     * @param x
     */
    public void addFirst(int x){
        size ++;
        IntNode n = new IntNode(x, null);
        n.next = this.sentinel.next;
        sentinel.next = n;
    }

    /**
     * add x to the end of the list
     * @param x
     */
    public void addLast(int x){
        size ++;
        IntNode n = new IntNode(x,null);
        IntNode tmp = this.sentinel;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = n;
    }

    /**
     * return the SLList's size.
     * @return
     */
    public int my_size(){
        int size = 0;
        IntNode tmp = this.sentinel;
        while(tmp.next != null){
            size ++;
            tmp = tmp.next;
        }
        return size;
    }

    /**
     * return the size that begin with node p.
     * @return size.
     */
    /*private static int size(IntNode p){
        if(p.next == null)
            return 1;
        return 1 + size(p.next);
    }
     */
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        SLList l = new SLList();
        System.out.println(l.getFirst());
    }
}
