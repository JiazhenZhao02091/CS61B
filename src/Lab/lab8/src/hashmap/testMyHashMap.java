package Lab.lab8.src.hashmap;

import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/2/23
 * 类说明：
 */
public class testMyHashMap {

    /**
     * put
     */
    @Test
    public void test1() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(2, 2);
        map.put(2, 2);
        map.put(2, 2);
        System.out.println(map.size());
    }

    /**
     * get
     */
    @Test
    public void test2() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(map.get(i));
        }
    }


    /**
     * clear
     */
    @Test
    public void test3() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());
        map.printHashMap();

        map.clear();
        System.out.println(map.size());
        map.printHashMap();
    }


    /**
     * resize
     */
    @Test
    public void test4(){
        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        for (int i = 0; i < 30; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());
        map.printHashMap();
    }


}
