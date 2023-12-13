package Homework.Homework0;

/**
 * @author JiazhenZhao
 * 2023/12/13
 * 类说明：
 */
public class CreativeExercise1b {
    public static void DrawTriangle(int x){
        for(int i = 1 ; i <= x ; i ++){
            for(int j = 0 ; j < i ; j ++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DrawTriangle(5);
        System.out.println("x == 10");
        DrawTriangle(10);
    }
}
