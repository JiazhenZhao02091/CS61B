package Project.project1.projectGold;

import static org.junit.Assert.*;

import Project.project0.StdRandom;
import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/2/2
 * 类说明：
 * 测试 StudentArrayDeque 中有关 addFirst(), addLast(), removeFirst(), removeLast() 中的错误
 * ArrayDequeSolution 为正确实现，因此可以用它的输出来和 StudentArrayDeque 来进行对比
 */
public class TestArrayDequeGold {

    public static StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
    public static ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();

    public String message = "";


    public static void compare() {
        Integer[] expect_nums = new Integer[arrayDequeSolution.size() + 1];
        Integer[] actual_nums = new Integer[arrayDequeSolution.size() + 1];
        for (int i = 0; i < arrayDequeSolution.size(); i++) {
            actual_nums[i] = studentArrayDeque.get(i);
            expect_nums[i] = arrayDequeSolution.get(i);
        }
        assertArrayEquals(expect_nums, actual_nums);
    }

    /**
     * Test AddFirst and AddLast
     */
    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            int randNum = StdRandom.uniform(2);// 0 1
            if (randNum == 1) {
                studentArrayDeque.addFirst(i);
                arrayDequeSolution.addFirst(i);
            } else {
                studentArrayDeque.addLast(i);
                arrayDequeSolution.addLast(i);
            }
        }
        studentArrayDeque.printDeque();
        arrayDequeSolution.printDeque();
        compare();

        /** RemoveFirst and RemoveLast*/
        for (int i = 0; i < 10; i++) {
            int randNum = StdRandom.uniform(2);// 0 1
            if (randNum == 1) {
                studentArrayDeque.removeFirst();
                arrayDequeSolution.removeFirst();
            } else {
                Integer tmp_actual = studentArrayDeque.removeLast();
                Integer tmp_expect = arrayDequeSolution.removeLast();
            }
        }
        studentArrayDeque.printDeque();
        arrayDequeSolution.printDeque();
        compare();
    }

    /**
     * RemoveFirst and RemoveLast
     */
    @Test
    public void test2() {
        int size = 0;
        int flag = 0;
        for (int i = 0; i > -1; i++) {

            int randNum = StdRandom.uniform(4);// 0 1 2 3
            if (randNum == 0) {
                studentArrayDeque.addFirst(i);
                arrayDequeSolution.addFirst(i);
                message = message.concat("addFirst(" + i + ")\n");
                size ++;
                compare();
            } else if (randNum == 1) {
                studentArrayDeque.addLast(i);
                arrayDequeSolution.addLast(i);
                message = message.concat("addLast(" + i + ")\n");
                size ++;
                compare();
            } else if (randNum == 2 && size > 0) {
                Integer tmp1 = studentArrayDeque.removeFirst();
                Integer tmp2 = arrayDequeSolution.removeFirst();
                message = message.concat("removeFirst(" + i + ")\n");
                assertEquals(message, tmp1, tmp2);
                size --;
                compare();
            } else if (randNum == 3 && size > 0) {
                Integer tmp1 = studentArrayDeque.removeLast();
                Integer tmp2 = arrayDequeSolution.removeLast();
                message = message.concat("removeLast(" + i + ")\n");
                assertEquals(message, tmp1, tmp2);
                size --;
                compare();
            } else {
                compare();
                continue;
            }
            flag ++;
            if(flag >= 100){
                System.out.println("PASSED " + flag + " ALL CASES !!!");
                break;
            }
        }
    }
}
