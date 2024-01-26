package Course.course4.course2;

/**
 * @author JiazhenZhao
 * 2024/1/26
 * 类说明：
 */
public class main {
    public static void main(String[] args) {


    }
}
/**
 *  子类继承父类之后，再调用方法的过程中，编译器只允许根据 **静态类型**做事
 *  针对于重写方法（Override）实际调用的方法基于  **动态类型**
 *      如果没重写就会出现 Compile error ，即使继承子类中具有该方法
 */

/*
    children c = new children()
    father f = c;
    f.c1(); // 没有 Override 调用 father    的 c1()
    f.c2(); // Override     调用 children 重写的 c2()
    f.c3(); // c3 在 children 中有，在father中没有
            // Compile ERROR!
 */