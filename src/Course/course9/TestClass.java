package Course.course9;

import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/2/7
 * 类说明：
 */
public class TestClass {
    @Test
    public void test(){
        QuickUnionDS quickUnionDS = new QuickUnionDS(4);
        // 0 1 2 3
        quickUnionDS.connect(0, 1);

        quickUnionDS.toString();

        quickUnionDS.connect(3, 2);
        quickUnionDS.toString();

        quickUnionDS.connect(2, 1);
        quickUnionDS.toString();
    }
}
