package Course.course3.course1;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
/**
 * @author JiazhenZhao
 * 2024/1/18
 * 类说明：
 */
public class TestSort {

    @Test
    public void TestSortMethod() {
        String[] inputs = {"e", "d", "c", "b", "a", "w"};
        String[] excepts = {"a", "b", "c", "d", "e", "w"};
        Sort.sort(inputs);
        org.junit.Assert.assertArrayEquals(excepts, inputs);
        assertArrayEquals(excepts, inputs);
        System.out.println("PASS ALL CASES !!!");
    }
    @Test
    public void TestSwap() {
        String[] inputs = {"e", "d", "c", "b", "a", "w"};
        String[] excepts = {"a", "b", "c", "d", "e", "w"};
        Sort.sort(inputs);

        for (int i = 0; i < inputs.length; i++)
            if (!inputs[i].equals(excepts[i])) {
                System.out.println("position " + i + " not match.");
                return;
            }
        System.out.println("PASS ALL CASES !!!");
    }

    @Test
    public void print(){
        System.out.println("Hello, world !!!");
    }

    public static void main(String[] args) {
//        TestSortMethod();
    }
}
