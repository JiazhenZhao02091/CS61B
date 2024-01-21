package Project.project1A;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author JiazhenZhao
 * 2024/1/21
 * 类说明：
 */
public class TestCircleSentinel {

    /**
     * Print
     */
    @Test
    public void test() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addFirst(-1);
        l.addLast(2);
        l.addLast(3);
        int[] expects = {-1, 0, 1, 2, 3};
        int[] inputs = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            inputs[i] = l.get(i);
        Assert.assertArrayEquals(expects, inputs);
        System.out.println("Pass test PRINT !!!");
    }

    /**
     * Add
     */
    @Test
    public void test1() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addFirst(-1);
        l.addLast(2);
        l.addLast(3);
        int[] expects = {-1, 0, 1, 2, 3};
        int[] inputs = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            inputs[i] = l.get(i);
        Assert.assertArrayEquals(expects, inputs);
        System.out.println("Pass test ADD !!!");
    }

    /**
     * Remove
     */
    @Test
    public void test2() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        l.removeFirst();
        l.removeLast();
        int[] expects = {1, 2};
        int[] inputs = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            inputs[i] = l.get(i);
        Assert.assertArrayEquals(expects, inputs);
        System.out.println("Pass test Remove !!!");
    }

    /**
     * size function
     */
    @Test
    public void test3() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        l.removeFirst();
        l.removeLast();
        int tmp_size = 2;
        Assert.assertEquals(tmp_size, l.size());
        System.out.println("Pass test Size !!!");
    }

    /**
     * get no recursion function
     */
    @Test
    public void test4() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        int[] excepts = {0, 1, 2, 3};
        int[] inputs = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            inputs[i] = l.get(i);
        Assert.assertArrayEquals(excepts,inputs);
        System.out.println("Pass test Get !!!");
    }

    /**
     * get recursion function
     */
    @Test
    public void test5() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(1);
        l.addFirst(0);
        l.addLast(2);
        l.addLast(3);
        int[] excepts = {0, 1, 2, 3};
        int[] inputs = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            inputs[i] = l.get(i);
        Assert.assertArrayEquals(excepts,inputs);
        System.out.println("Pass test Get Recursion !!!");
    }

}
