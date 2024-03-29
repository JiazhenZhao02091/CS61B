package Course.course2.course3;

/**
 * @author JiazhenZhao
 * 2024/1/15
 * 类说明：
 */
public class SLList {


    private IntNode sentinel;
    private int size;
    private IntNode end; /* 指向末尾节点 */

    /**
     * Create empty list.
     */
    public SLList(){
        size = 0;
        sentinel = new IntNode(63,null,null);
    }
    /** use a int variable create list. */
    public SLList(int x){
        sentinel = new IntNode(63,null,null);
        IntNode first = new IntNode(10, null);
        sentinel.next = first;
        first.prev = sentinel;
        size = 1;
        end = first;
    }
    /** use numbers create list. */
    public SLList(int[] nums){
        SLList l = new SLList(nums[0]);
        for(int i = 1 ; i <= nums.length ; i ++){
            l.addLast(nums[i]);
        }
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
        if(x > size){
            System.out.println("bound error.");
            return null;
        }
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
        IntNode n = new IntNode(x, null,sentinel);
        this.sentinel.next.prev = n;
        n.next = this.sentinel.next;
        sentinel.next = n;
    }

    /**
     * add x to the end of the list
     * @param x
     */
    public void addLast(int x){
        size ++;
        IntNode n = new IntNode(x,sentinel,end);
        end.next = n;
        end = n;
    }

    /**
     * return the SLList's size.
     * @return
     */
    public int my_size(){
        int size = 0;
        IntNode tmp = this.sentinel;
        while(tmp.next != null){
            if(tmp.next == sentinel)
                break;
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

    /**
     * delete the first member in the array.
     */
    public void deleteFirst(){
        IntNode tmp = this.sentinel.next;
        this.sentinel.next = tmp.next;
        tmp = null;
        size --;
    }

    public static void main(String[] args) {
        SLList l = new SLList(10);
        l.addFirst(9);
        l.addLast(11);
        System.out.println(l.getItem(0).item);
        System.out.println(l.getItem(1).item);
        System.out.println(l.getItem(2).item);
        System.out.println(l.size());
        System.out.println(l.my_size());
    }
}
