package Course.course3.course1;

/**
 * @author JiazhenZhao
 * 2024/1/18
 * 类说明：
 */
public class Sort {
    public static void sort(String[] arrays) {
        int index = 0;
        while (index < arrays.length) {
            // Find the smallest item in arrays.
            String tmp_min = arrays[index];
            int tmp_index = index;
            for (int i = index; i < arrays.length; i++) {
                if (arrays[i].compareTo(tmp_min) <= 0) {
                    tmp_min = arrays[i];
                    tmp_index = i;
                }
            }
            // Move it to the front
            String tmp = arrays[index];
            arrays[index] = tmp_min;
            arrays[tmp_index] = tmp;
            // Circle ...
            index ++;
        }

    }


    private void findSmallIndex(String[] x){

    }

    private void swap(String[]x, int a, int b){

    }

    private void sort(String[] x, int start){

    }
}

