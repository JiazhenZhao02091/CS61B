package Course.course2.guide.A2;

import Project.project0.In;
import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/1/19
 * 类说明：
 */
public class IntList {
    public int first;
    public IntList rest;

    public IntList() {
    }

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }
    //
    public void addAdjacent(IntList list){
        IntList tmp = list;
        for( ; tmp != null && tmp.rest != null; tmp = tmp.rest){
            if(tmp.first == tmp.rest.first){
                tmp.first *= 2;
                tmp.rest = tmp.rest.rest;
                // size --
            }
        }
    }
    public void addLast(int x, IntList list){
        IntList tmp = list;
        for( ; tmp != null ; tmp = tmp.rest){
            if(tmp.rest == null){
                IntList n = new IntList(x, null);
                tmp.rest = n;
                return;
            }
        }
    }

    public void Square(IntList list){
        IntList tmp = list;
        for( ; tmp != null ; tmp = tmp.rest){
            int square = tmp.first * tmp.first;
            IntList n = new IntList(square, tmp.rest);
            tmp.rest = n;
            tmp = tmp.rest;
        }
    }

    public void addLastSquare(int x, IntList list){
        Square(list);
        IntList tmp = list;
        for( ; tmp != null ; tmp = tmp.rest){
            if(tmp.rest == null){
                IntList n = new IntList(x, null);
                tmp.rest = n;
                return;
            }
        }

    }
    public void print(IntList list){
        System.out.println("print ....");
        IntList tmp = list;
        for( ; tmp != null ; tmp = tmp.rest){
            System.out.println(tmp.first);
        }
    }


}
