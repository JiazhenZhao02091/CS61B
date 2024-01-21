package Course.course4.course1;

import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/1/18
 * 类说明：
 */
public class OverReadandOverLoad {

    public interface Animal {
        default public void a(Animal animal) {
            System.out.println("Animal a ...");
        }

        default public void b() {
            System.out.println("Animal b ...");
        }

        default public void c() {
            System.out.println("Animal c ...");
        }
    }

    public class Dog implements Animal {
        public Dog() {
        }

        public void a(Dog dog) {
            System.out.println("Dog a ...");
        }

        @Override
        public void b() {
            System.out.println("Dog b ...");
        }
    }

    @Test
    public void test() {
        Dog d = new Dog();
        Animal a = new Dog();
        d.a(d);
        d.a(a); // Dog d
        a.a(d); // Animal a
        /**
         * 子类方法中区分开重写和重载
         * 相同的函数名以及参数类型等才是重写
         * 重载的时候，会找到子类和父类之间区分度更为小的方法
         *  * 在这里就是去寻找了父类中的 a 方法
         *  * 因为 Dog 继承自 Animal，可能会有新的改变
         *  * 所以 Java 特性就会选择 Animal 匹配的方法，因为他一定不会出错
         *  * 且优先选择静态变量的方法
         */
    }
}
