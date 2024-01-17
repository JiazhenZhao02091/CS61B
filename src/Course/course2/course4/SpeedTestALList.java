package Course.course2.course4;

/**
 * @author JiazhenZhao
 * 2024/1/17
 * 类说明：
 */
public class SpeedTestALList {
    public static void main(String[] args) {
        AList l = new AList();
        int x = 10000;
        while(x >= 0){
            l.addLast(x);
            x --;
        }
    }
}
