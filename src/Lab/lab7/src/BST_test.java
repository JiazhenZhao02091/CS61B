package Lab.lab7.src;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JiazhenZhao
 * 2024/2/21
 * 类说明：
 *  Test
 */
public class BST_test {
    /** put */
    @Test
    public void test1(){
        BSTMap<String, Integer> map = new BSTMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.printInOrder();
    }
    /** get */

    @Test
    public void test2(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "a1");
        map.put(1, "a2");
        map.put(2, "b");
        map.put(3, "c");
        map.printInOrder();
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.get(3));
    }

    /** contains */
    @Test
    public void test3(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "a1");
        map.put(1, "a2");
        map.put(2, "b");
        map.put(3, "c");
        map.printInOrder();
        System.out.println(map.size());
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsKey(5));
    }

    /** size*/
    @Test
    public void test4(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "a1");
        map.put(1, "a2");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "c");
        map.put(5, "c");
        map.put(6, "c");
        map.printInOrder();
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        System.out.println(map.get(5));
    }

    /** clear*/
    @Test
    public void test5(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "a1");
        map.put(1, "a2");
        map.put(2, "b");
        map.put(3, "c");
        System.out.println(map.size());
        map.printInOrder();

        map.clear();
        System.out.println(map.size);
        map.printInOrder();
    }

    /** KeySet */
    @Test
    public void test6(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "a1");
        map.put(1, "a2");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "c");
        map.put(6, "c");
        System.out.println(map.size());
        map.printInOrder();
        Set<Integer> set = map.keySet();
        System.out.println("set size = " + set.size() + " map size = " + map.size());

    }

    /** remove that no child */
    @Test
    public void test7(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(15, "a");
        map.put(20, "a");
        map.put(5, "a");
        map.put(8, "a");
        map.put(9, "a");
        map.put(7, "a");
        map.put(3, "a");
        map.put(4, "a");
        map.put(2, "a");
        map.printInOrder();

        map.remove(20);
        System.out.println("remove ... ");
        System.out.println("size = " + map.size());
        map.printInOrder();

        map.remove(9);
        System.out.println("remove ...");
        System.out.println("size = " + map.size());
        map.printInOrder();
    }

    /** remove that one child*/
    @Test
    public void test8(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(15, "a");
        map.put(20, "a");
        map.put(5, "a");
        map.put(8, "a");
        map.put(9, "a");
        map.put(7, "a");
        map.put(3, "a");
        map.put(4, "a");
        map.put(2, "a");

        map.put(22, "a");
        map.printInOrder();
        System.out.println("size = " + map.size());

        map.remove(20);
        map.printInOrder();
        System.out.println("size = " + map.size());

    }
    
     /** remove that two child*/
    @Test
    public void test9(){
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(15, "a");
        map.put(20, "a");
        map.put(5, "a");
        map.put(8, "a");
        map.put(9, "a");
        map.put(7, "a");
        map.put(3, "a");
        map.put(4, "a");
        map.put(2, "a");
        map.printInOrder();
        System.out.println("size = " + map.size());
        map.remove(5);
        map.printInOrder();
        System.out.println("size = " + map.size());
    }
}
