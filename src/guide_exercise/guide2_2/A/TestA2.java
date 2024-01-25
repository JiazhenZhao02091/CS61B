package guide_exercise.guide2_2.A;

import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/1/19
 * 类说明：
 */
public class TestA2 {
    @Test
    public void test1(){
        IntList l = new IntList(1, null);
        l.addLast(1,l);
        l.addLast(2,l);
        l.addLast(3,l);
        l.print(l);
        // 1 1 2 3
        l.addAdjacent(l);
        System.out.println("Second ...");
        l.print(l);
        // 2 2 3
        l.addAdjacent(l);
        l.print(l);
        // 4 3
    }

    @Test
    public void test2(){
        IntList l = new IntList(1, null);
        l.addLast(2,l);
        l.print(l);
        l.addLastSquare(5,l);
        l.print(l);
        l.addLastSquare(7,l);
        l.print(l);
    }
}
