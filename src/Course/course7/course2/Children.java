package Course.course7.course2;

/**
 * @author JiazhenZhao
 * 2024/2/4
 * 类说明：
 */
public class Children extends Father{
    public void print2(){
        /*
         不可以直接访问父类的私有变量
         同样也不可以访问同包下的私有变量
         */
//        System.out.println(super.x);
        System.out.println(super.y);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
