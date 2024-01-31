package Course.course4.course3;

/**
 * @author JiazhenZhao
 * 2024/1/31
 * 类说明：
 */
public class maxFunction {
    /**
     * return the max element of an array.
     * */
    public static ourCompareTo max(ourCompareTo[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }


    public static void main(String[] args) {

    }
}
