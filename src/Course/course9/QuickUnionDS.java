package Course.course9;

import Course.course9.DisjointSets;

/**
 * @author JiazhenZhao
 * 2024/2/7
 * 类说明：
 */
public class QuickUnionDS implements DisjointSets {
    private int[] id;

    public QuickUnionDS(int size){
        id = new int[size];
        for(int i = 0 ; i < size ; i ++){
            id[i] = -1;
        }
    }

    /** 返回元素 x 对应的父节点的下标 */
    private int find(int x){
        if(id[x] == -1)
            return x;
        else return find(id[x]);
    }

    @Override
    public void connect(int p, int q) {
        int father_p = find(p);
        int father_q = find(q);
        id[father_q] = father_p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public String toString(){
        for(int i = 0 ; i < id.length ; i ++){
            System.out.println("i == " + i + "  id[i] = " + id[i]);
        }
        return "";
    }
}
