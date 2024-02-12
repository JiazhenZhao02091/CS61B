package Course.chapter21;

/**
 * @author JiazhenZhao
 * 2024/2/12
 * 类说明：
 * getSmallestElement()
 * removeSmallest()
 * addElement()
 */
public class TreeC<Key> {
    Key[] keys;

    public static void swap(int a,int b){
        System.out.println("a = " + a + ", b = " + b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a = " + a + ", b = " + b);
    }

    public int parent(int x) {
        return (x - 1) / 2;
    }

    public void swim(int x) {
        if(x < parent(x)){
            swap(x, parent(x));
            swim(parent(x));
        }
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        swap(x, y);
        System.out.println("x = " + x + ", y = " + y);
    }

}
