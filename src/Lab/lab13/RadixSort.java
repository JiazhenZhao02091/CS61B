package Lab.lab13;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 */
public class RadixSort {

    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        int size = asciis.length;
        String[] copy_array = new String[size];
        for (int i = 0; i < size; i++)
            copy_array[i] = asciis[i];
        int max_length = 0;
        for (String s : asciis)
            max_length = Math.max(max_length, s.length());
        for (int i = max_length - 1; i >= 0; i --)
            sortHelperLSD(copy_array, i);
        return copy_array;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     *
     * @param asciis Input array of Strings
     * @param index  The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] bucket = new int[257];
        for (String s : asciis) {
            int c = s.charAt(index);
            bucket[c]++;
        }
        // 计算所有的点对应下标索引
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }
        //
        String[] sorted = new String[asciis.length];
        for(int i = 0 ; i < asciis.length ; i ++){
            int c = asciis[i].charAt(index);
            int tmp = bucket[c] - 1;
            bucket[c] --;
            sorted[tmp] = asciis[i];
        }
        System.arraycopy(sorted, 0, asciis, 0, asciis.length);
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start  int for where to start sorting in this method (includes String at start)
     * @param end    int for where to end sorting in this method (does not include String at end)
     * @param index  the index of the character the method is currently sorting on
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        // Optional LSD helper method for required LSD radix sort
        int[] bucket = new int[257];
        for (String s : asciis) {
            int c = s.charAt(index);
            bucket[c]++;
        }
        // 计算所有的点对应下标索引
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }
        //
        String[] sorted = new String[asciis.length];
        for(int i = 0 ; i < asciis.length ; i ++){
            int c = asciis[i].charAt(index);
            int tmp = bucket[c] - 1;
            bucket[c] --;
            sorted[tmp] = asciis[i];
        }
        System.arraycopy(sorted, 0, asciis, 0, asciis.length);
        return;
    }
}
