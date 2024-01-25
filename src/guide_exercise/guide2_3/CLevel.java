package guide_exercise.guide2_3;

/**
 * @author JiazhenZhao
 * 2024/1/24
 * 类说明：
 *      使用 object 来存储不同的属性
 */
public class CLevel {
    public static void main(String[] args) {
        Object[][] objects = new Object[][]{{"a",1,1.2},{"b",2,2.2},{"c",3,3.2}};
        System.out.println(objects.toString());
        for(int i = 0 ; i < objects.length ; i ++){
            for (int j = 0 ; j < objects[i].length ; j ++){
                System.out.println(objects[i][j]);
            }
        }
    }
}
