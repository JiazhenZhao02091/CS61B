package Course.course9;

/**
 * @author JiazhenZhao
 * 2024/2/7
 * 类说明：
 * TODO: 如何让根节点的值为 -(size of tree)
 *       See Lab6!
 */
public class WeightedQuickUnionDS implements DisjointSets{
    private int[] id;

    public WeightedQuickUnionDS(int size){
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
//        if(id[father_p] >= id[father_p]){
//            id[father_p] = father_q;
//
//        }
//        id[father_q] = father_p;
//        id[father_p] -= 1; // size ++ ;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
