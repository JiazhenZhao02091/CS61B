package Course.course1;

/**
 * @author JiazhenZhao
 * 2023/12/14
 * 类说明：
 */
public class Dog {
    public int weight;

    public Dog(int w){
       weight =  w;
    }

    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weight > d2.weight) {
            return d1;
        }
        return d2;
    }

    public void makeNoise(){
        if (weight < 10){
            System.out.println("yipd");
        } else if (weight<20) {
            System.out.println("wooof");
        }else {
            System.out.println("wwwww");
        }
    }
}
