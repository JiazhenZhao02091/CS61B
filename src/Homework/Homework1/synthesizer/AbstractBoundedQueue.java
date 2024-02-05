package Homework.Homework1.synthesizer;

/**
 * @author JiazhenZhao
 * 2024/2/5
 * 类说明：
 * 所有实现接口的类都必须完全实现所有接口类中的方法，除非使用 abstract 关键字，抽象类
 * 此外抽象类中区别于接口类：
 * 抽象类中可以添加是实例变量等功能
 * 在抽象类中也可以定义方法，但需要加上 abstract 关键字：
 * public abstract void toMove();
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /**
     * protected
     * subclass and the same package's class can access.
     */
    protected int fillCount;
    protected int capacity;
    public int capacity(){
        return capacity;
    }
    public int fillCount(){
        return fillCount;
    }

}
