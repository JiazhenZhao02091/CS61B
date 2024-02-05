package Homework.Homework1.synthesizer;// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
import Homework.Homework1.synthesizer.AbstractBoundedQueue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 实现 Iteration 方法
 * 首先需要在其接口类继承 Iterable<T> 定义 iterator<T> iterator()；用于返回 iterator 类,
 * 如果存在抽象类，抽象类不用实现
 * 因为 iterator()在接口中被定义，所以需要重写该方法
 * 在子类中，需要构建私有Class 用于构造 iterator类，以便它可以在 iterator() 中返回相应的类
 * 在私有Class中，需要继承 iterator
 * 实现 next 和 hasNext 函数方法，
 * @param <T>
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if(isFull())
            throw new RuntimeException("Ring buffer overflow");
        rb[first] = x;
        first = (first + 1) % capacity;

        fillCount ++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(isEmpty())
            throw new RuntimeException("Ring buffer underflow");
        T tmp = rb[last];
        last = (last + 1) % capacity;
        fillCount --;
        return tmp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[last];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }



    public String toString(){
        System.out.println("First = " + first);
        System.out.println("Last  = " + last);
        return "";
    }

    private class ArrayRingBufferIterator implements Iterator<T>{

        private int wizPos;

        public ArrayRingBufferIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < fillCount;
        }

        @Override
        public T next() {
            T returnItem = rb[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
