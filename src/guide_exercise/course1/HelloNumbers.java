package guide_exercise.course1;

/**
 * @author JiazhenZhao
 * 2023/12/13
 * 类说明：
 */
public class HelloNumbers {
    /** Returns a larger number in x and y.
     * @param x int
     * @param y int
     * @return int
     * @precondition none
     * */
    public static int Large(int x,int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args){
        int x = 0;
        while(x < 10){
            System.out.println(x);
            x = x + 1;
        }
        System.out.println(Large(-5,10));
    }
}
