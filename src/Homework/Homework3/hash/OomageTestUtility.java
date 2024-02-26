package Homework.Homework3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int[] buckets_num = new int[M];
        int N = 0;
        for (Oomage o : oomages) {
            int bucket_Num = (o.hashCode() & 0x7FFFFFFF) % M;
            N++;
            buckets_num[bucket_Num]++;
        }
        double max = N / 2.5;
        double min = N / 50;

        for (int i = 0; i < M; i++) {
            if (buckets_num[i] > 0 && (buckets_num[i] > max || buckets_num[i] < min)) {
                return false;
            }
        }
        return true;
    }


}
