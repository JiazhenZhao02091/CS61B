package Homework.Homework1.synthesizer;

import java.util.Iterator;

/**
 * @author JiazhenZhao
 * 2024/2/5
 * 类说明：
 * BigProgrammer:
 * Interface --> abstract class --> realwork class
 * SmallProgrammer:
 * abstract class --> realwork class (Choise)
 */
public interface BoundedQueue<T> extends Iterable<T>{

    public int capacity();     // return size of the buffer

    public int fillCount();    // return number of items currently in the buffer

    public void enqueue(T x);  // add item x to the end

    public T dequeue();        // delete and return item from the front

    public T peek();           // return (but do not delete) item from the front

    default public boolean isEmpty(){
        return fillCount() == 0;
    }

    default public boolean isFull(){
        return fillCount() == capacity();
    }

    public Iterator<T> iterator();
}
