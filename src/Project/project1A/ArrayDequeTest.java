package Project.project1A;

import org.junit.Test;
import sun.net.util.IPAddressUtil;

/**
 * @author JiazhenZhao
 * 2024/1/22
 * 类说明：
 */
public class ArrayDequeTest {
    /**
     * Print
     */
    @Test
    public void test() {
        Integer[] nums = {1, 2, 3, 4, 5};
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(nums);
        arrayDeque.print();
    }

    /**
     * ADD
     */
    @Test
    public void test1() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(0);
        arrayDeque.addLast(4);
        arrayDeque.print();
    }

    /**
     * REMOVE
     */
    @Test
    public void test2() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(0);
        arrayDeque.addLast(4);
        arrayDeque.print();
        // 0 1 2 3 4
        arrayDeque.removeFirst();
        arrayDeque.print();
        // 1 2 3 4
        arrayDeque.removeLast();
        arrayDeque.print();
        // 1 2 3
    }

    /**
     * GET
     */
    @Test
    public void test3() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(0);
        arrayDeque.addLast(4);
        arrayDeque.print();
        // 0 1 2 3 4
        System.out.println(arrayDeque.get(0));// 0
        System.out.println(arrayDeque.get(1));// 1
        System.out.println(arrayDeque.get(2));// 2
        System.out.println(arrayDeque.get(4));// 4
    }

    /**
     * Resize
     */
    @Test
    public void test4() {
        Integer[] nums = {1, 2, 3, 4, 5};
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(nums);
        arrayDeque.print();
        arrayDeque.addFirst(0);
        arrayDeque.print();

        /*
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(0);
        arrayDeque.addLast(4);
        arrayDeque.print();
        arrayDeque.resize(16);
         */
    }

    /**
     * Resize
     */
    @Test
    public void test5(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(10);
        arrayDeque.addFirst(9);
        arrayDeque.addFirst(8);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(6);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(0);
        arrayDeque.print();
        // 0 1 2 3 4 5 6 7 8 9 10
    }

    @Test
    public void test6(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(6);
        arrayDeque.isEmpty();
        arrayDeque.addFirst(8);
        arrayDeque.print();
        System.out.println(arrayDeque.first + arrayDeque.end);
        System.out.println(arrayDeque.removeFirst());
    }
    @Test
    public void test7(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.isEmpty();
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        arrayDeque.addLast(8);
        arrayDeque.print();
    }

    @Test
    public void test8(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        System.out.println(arrayDeque.removeFirst());
        arrayDeque.print();
    }
    @Test
    public void test9(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.isEmpty();
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        System.out.println(arrayDeque.removeLast());
        arrayDeque.print();
    }
    @Test
    public void test10(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.addFirst(1);
        System.out.println(arrayDeque.get(1));
        System.out.println(arrayDeque.removeFirst());
    }


    @Test
    public void test11(){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(1.2);
    }
}
