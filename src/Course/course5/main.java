package Course.course5;

import Project.project1.project1A.ArrayDeque;
import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/2/2
 * 类说明：
 */
public class main {
    public class Date {
        public final int x;         // 只能被赋值一次
        public int y;

        public Date(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void print() {
            System.out.println("x = " + x + ", y  = " + y);
        }
    }

    @Test
    public void test() {
        Date date = new Date(1, 2);
        date.print();
        date.y = 3;
        date.print();
    }

    /**
     * 使用 Reflection 可以破坏有关 private 和 finial 相关的所有操作
     */
    @Test
    public void test1(){
        final ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        /**
         * arrayDeque 这个指针变量是不可以改变的，即他所指向的地址不变
         * 但是它指向的位置的内容是可以改变的
         */
        /* 这种是不可以的
        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        arrayDeque = arrayDeque;
         */
        arrayDeque.addLast(1);
        arrayDeque.addFirst(2);
    }

}
