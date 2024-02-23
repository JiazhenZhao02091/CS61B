package Project.project1.project1B;

/**
 * @author JiazhenZhao
 * 2024/2/1
 * 类说明：
 */
public interface Deque<T> {

    public void resize(int capacity);

    public void addFirst(T x);

    public void addLast(T x);

    public T removeFirst();

    public T removeLast();

    public void print();

    public void printDeque();


    public void checkFEBount();

    public int size();

    public T get(int index);

    public boolean isEmpty();


}
