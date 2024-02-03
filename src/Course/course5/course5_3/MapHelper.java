package Course.course5.course5_3;

/**
 * @author JiazhenZhao
 * 2024/2/2
 * 类说明：
 */
public class MapHelper {
    public static <K, V> V get(Map61B<K, V> map61B, K key) {
        V value = map61B.get(key);
        return value; // Null or Not null
    }

    /**
     * 在继承中使用 extends 意义是使子类继承父类的功能
     * 在泛型中使用 extends 意义是约束方法必须必备某种特性而不是赋予新功能；
     *      它只是告诉你事情，而没有做太多的事情
     */
    public static <K extends Comparable<K>, V>  K maxKey(Map61B<K, V> map61B) {
        K maxKey = map61B.keys()[0];
        /*
        for (int i = 0; i < map61B.size(); i++) {
            if (map61B.keys()[i] > maxKey)
                maxKey = map61B.keys()[i];
        }
         */
        return maxKey;
    }
}
