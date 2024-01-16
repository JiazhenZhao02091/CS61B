package Course.course2.course3;

/**
 * @author JiazhenZhao
 * 2024/1/15
 * 类说明：
 */
public class GLList<LocsNess> {

    private StufNode sentinel;
    private int size;
    private StufNode end; /* 指向末尾节点 */

    /**
     * Create empty list.
     */
    public GLList(){
        size = 0;
        sentinel = new StufNode(63,null,null);
    }

    public GLList(LocsNess x){
        sentinel = new StufNode(63,null,null);
        StufNode first = new StufNode(10, null);
        sentinel.next = first;
        first.prev = sentinel;
        size = 1;
        end = first;
    }

    /**
     * return the first item of the list.
     *
     * @return
     */
    public Object getFirst(){
        if(sentinel.next == null){
            System.out.println("No first item current.");
            return null;
        }
        return sentinel.next.item;
    }

    /**
     * get x. item of the list
     * @param x
     * @return
     */
    public StufNode getItem(int x){
        if(x == 0)
            return this.sentinel.next;
        if(x > size){
            System.out.println("bound error.");
            return null;
        }
        StufNode tmp = this.sentinel.next;
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
    public void addFirst(LocsNess x){
        size ++;
        StufNode n = new StufNode(x, null,sentinel);
        this.sentinel.next.prev = n;
        n.next = this.sentinel.next;
        sentinel.next = n;
    }

    /**
     * add x to the end of the list
     * @param x
     */
    public void addLast(LocsNess x){
        size ++;
        StufNode n = new StufNode(x,sentinel,end);
        end.next = n;
        end = n;
    }

    /**
     * return the SLList's size.
     * @return
     */
    public int my_size(){
        int size = 0;
        StufNode tmp = this.sentinel;
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
    /*private static int size(StufNode p){
        if(p.next == null)
            return 1;
        return 1 + size(p.next);
    }
     */
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        GLList l = new GLList(10);
        l.addFirst(9);
        l.addLast(11);
        System.out.println(l.getItem(0).item);
        System.out.println(l.getItem(1).item);
        System.out.println(l.getItem(2).item);
        System.out.println(l.size());
        System.out.println(l.my_size());
    }
}
