package Course.course2;

/**
 * @author JiazhenZhao
 * 2023/12/16
 * 类说明：
 */
public class IntList {
    public int first;
    public IntList reset;

    public IntList(int f, IntList r){
        first = f;
        reset = r;
    }

    /**
     * Return a int type size about a L linklist.
     * @return
     */
    public int size(){
        if(reset == null){
            return 1;
        }
        return 1 + this.reset.size();
        /*
        IntList l = L;
        int size =  0;
        while(l.reset != null) {
            System.out.println(l.first);
            size++;
            l = l.reset;
        }
        return size + 1;
        */
    }

    /**
     * returns the i member of the LinkList.
     * @param i
     * @return
     */
    public IntList get(int i){
        if(i == 0)
            return this;
        if(this == null){
            System.out.println("No this member, please check the index of List.");
            return null;
        }
        return this.reset.get(i - 1);
    }

    public IntList noReget(int i){
        IntList l = this;
        while(i != 0){
            l = l.reset;
            i -- ;
        }
        return l;
    }

    public static void main(String[] args) {
        IntList l = new IntList(15, null);
        l = new IntList(20,l); //  l -> null  ---> l -> new -> null
        l = new IntList(100, l);
//        System.out.println(l.size(l));
        System.out.println(l.size());
        System.out.println(l.get(2).first);
        System.out.println(l.noReget(2).first);
    }
}
