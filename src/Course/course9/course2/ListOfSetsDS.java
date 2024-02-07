package Course.course9.course2;

import Course.course9.course1.DisjointSets;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author JiazhenZhao
 * 2024/2/7
 * 类说明：
 */
public class ListOfSetsDS implements DisjointSets {
    public LinkedList<Set<Integer>> item;

    public ListOfSetsDS(int size){
        item = new LinkedList<Set<Integer>>();
        for(int i = 0 ; i < size ; i ++){
            Set<Integer> s = new HashSet();
            s.add(i);
            item.add(s);
        }
    }

    @Override
    public void connect(int p, int q) {
        int index_p = 0,index_q = 0;
        for(int i = 0 ; i < item.size() ; i ++){
            Set<Integer> s = item.get(i);
            for(Integer tmp : s){
                if(tmp == p){
                    index_p = i;
                    break;
                }
            }
        }
        for(int i = 0 ; i < item.size() ; i ++){
            Set<Integer> s = item.get(i);
            for(Integer tmp : s){
                if(tmp == q){
                    index_q = i;
                    break;
                }
            }
        }
        Set<Integer> tmp = item.remove(index_q);
        for(Integer x : tmp){
            item.get(index_p).add(x);
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        boolean flag_p = false, flag_q = false;
        for(int i = 0 ; i < item.size() ; i ++){
            Set<Integer> s = item.get(i);
            for(Integer tmp : s){
                if(tmp == p)
                    flag_p = true;
                if(tmp == q)
                    flag_q = true;
            }
        }
        return flag_q && flag_p;
    }
}
