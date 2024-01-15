package Course.course2.course1;
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

    public IntList noRecursion(int i){
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
        System.out.println(l.get(1).first);
        System.out.println(l.size());
        System.out.println(l.get(2).first);
        System.out.println(l.noRecursion(2).first);
    }
}
/*
    必须递归创建
    必须手动指定列表中每个节点的下一个节点
 */
