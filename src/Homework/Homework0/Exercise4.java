package Homework.Homework0;

/**
 * @author JiazhenZhao
 * 2023/12/13
 * 类说明：
 */
public class Exercise4 {
    public static void windowPosSum(int[] a, int n){
        for(int i = 0 ; i < a.length ; i ++)
        {
            if(a[i] < 0)
                continue;
            int tmp = n; // tmp == n == 3
            for(int j = 1 ; j <= tmp ; j ++)
            {
                if(i + j >= a.length)
                    break;
                a[i] = a[i] + a[i + j];
            }
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, -3, 4, 5, 4};
        int[] b = new int[]{1, -1, -1, 10, 5, -1};
        int n = 3;
        int m = 2;
        windowPosSum(a,n);
        windowPosSum(b,m);
        System.out.println(java.util.Arrays.toString(a));
        System.out.println(java.util.Arrays.toString(b));
    }
}
