package Lab.lab13;

import org.junit.Assert;
import org.junit.Test;
/**
 * @author JiazhenZhao
 * 2024/2/29
 * 类说明：
 */
public class test {

    @Test
    public void test(){
        int x = 123;
    }

    @Test
    public void test_radix(){
        String[] strings = new String[5];
//        for(int i = 0 ; i < strings.length ; i ++){
//            strings[i] = "a" + i;
//        }
        for(int i = strings.length - 1 ; i >= 0 ; i --){
            strings[i] = "a" + i + "b";
        }
        RadixSort.sort(strings);
//        for (String s : strings){
//            System.out.println(s);
//        }

        String[] expect = new String[5];
        for(int i = 0 ; i < strings.length ; i ++){
            expect[i] = "a" + i + "b";
        }
        Assert.assertEquals(expect, strings);
    }

}
