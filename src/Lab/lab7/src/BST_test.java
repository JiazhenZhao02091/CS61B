package Lab.lab7.src;

import org.junit.Test;

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
}
