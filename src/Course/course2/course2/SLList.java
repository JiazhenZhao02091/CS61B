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

    private IntNode first;
    private int size;

    /**
     * Create empty list.
     */
    public SLList(){
        size = 0;
        first = null;
    }

    public SLList(int x){
        first = new IntNode(10, null);
        size = 1;
    }

    /**
     * return the first item of the list.
     * @return
     */
    public int getFirst(){
        return first.item;
    }

    /**
     * get x. item of the list
     * @param x
     * @return
     */
    public IntNode getItem(int x){
        if(x == 0)
            return this.first;
        IntNode tmp = this.first;
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
        n.next = this.first;
        first = n;
    }

    /**
     * add x to the end of the list
     * @param x
     */
    public void addLast(int x){
        size ++;
        IntNode n = new IntNode(x,null);
        IntNode tmp = this.first;
        if(tmp == null){
            first = n;
            return;
        }
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
        int size = 1;
        IntNode tmp = first;
        while(tmp.next != null){
            size ++;
            tmp = tmp.next;
        }
        return size;
    }

    /**
     * return the size that begin with node p.
     * @param p
     * @return
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
        SLList l = new SLList(10);
        l.addFirst(9);
        l.addFirst(8);
        l.addLast(11);
        l.addLast(12);
        l.addLast(13);
        System.out.println(l.getItem(0).item);
        System.out.println(l.getItem(1).item);
        System.out.println(l.getItem(2).item);
        System.out.println(l.getItem(3).item);
        System.out.println("list size  = " + l.size());

        SLList L  = new SLList();
        L.addLast(10);
        System.out.println(L.size());
    }
}
