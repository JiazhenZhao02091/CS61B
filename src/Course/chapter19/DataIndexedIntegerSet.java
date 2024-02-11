package Course.chapter19;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JiazhenZhao
 * 2024/2/11
 * 类说明：
 */
public class DataIndexedIntegerSet {


    public static void main(String[] args) {
        dog d1 = new dog(1,1);
        dog d2 = new dog(1, 1);
        d2 = d1;
        Integer s1 = d1.hashCode();
        Integer s2 = d2.hashCode();
        System.out.println("S1 = " + s1 + " S2 = " + s2);
        String x = "bbb";
        String y = "bbb";
        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println("x'hashCode is " + x.hashCode() + " y'hashCode is " + y.hashCode());
    }
    @Test
    public void test(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
    }
}

class dog{
    int x;
    int y;
    dog(int x, int y){
        this.x = x;
        this.y = y;
    }
}
/**
 * Integer x = String.hashCode("test");
 * nums[x % size ] = true;
 */