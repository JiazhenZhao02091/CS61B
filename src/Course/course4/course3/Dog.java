package Course.course4.course3;

/**
 * @author JiazhenZhao
 * 2024/1/31
 * 类说明：
 */
public class Dog implements ourCompareTo{
    public int size;
    public String name;

    @Override
    public int compareTo(Object o) {
        Dog d = (Dog) o;        // 不转换的话，无法确定是哪一种 `Object`
        if(this.size < d.size)
            return -1;
        else if(this.size == d.size)
            return 0;
        else
            return 1;
    }

    public Dog(int size, String name){
        this.size = size;
        this.name = name;
    }

    public Dog(String name){
        this.size = 0;
        this.name = name;
    }

    public void changeSize(){
        size ++;
    }
}
