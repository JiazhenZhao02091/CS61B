package Course.course5.course5_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author JiazhenZhao
 * 2024/2/2
 * 类说明：
 */
public class ArrayMapTest {
    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals(expected, (int)am.get(2));
        /**
         * assertEquals(Object, Object)
         * assertEquals((Integer)expected, am.get(2));
         * assertEquals(long, long)
         * assertEquals((long)expected, am.get(2));
         * assertEquals(expected, (long)am.get(2));
         * */
    }
}
