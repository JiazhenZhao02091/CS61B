package Project.project1.project1A;

import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/1/21
 * 类说明：
 */
public class TestTwoSentinel {

    /** Print */
    @Test
    public void test() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        l.printDeque();
    }

    /** Add */
    @Test
    public void test1() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        l.print();
    }

    /** Remove */
    @Test
    public void test2(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        l.print();
        // 0 1 2 3
        int r1 = l.removeFirst();
        l.print();
        // 1 2 3
        int r2 = l.removeLast();
        // 1 2
        l.print();
    }

    /** size function */
    @Test
    public void test3(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        System.out.println(l.size());
        l.removeFirst();
        System.out.println(l.size());
        l.removeLast();
        System.out.println(l.size());
    }

    /** get no recursion function */
    @Test
    public void test4(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        System.out.println(l.get(1));
        System.out.println(l.get(0));
        System.out.println(l.get(2));
        System.out.println(l.get(4)); // size max
    }

    /** get recursion function */
    @Test
    public void test5(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        System.out.println(l.getRecursive(1));
        System.out.println(l.getRecursive(0));
        System.out.println(l.getRecursive(2));
        System.out.println(l.getRecursive(4)); // size max
    }

}
