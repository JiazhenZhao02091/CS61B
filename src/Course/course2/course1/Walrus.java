package Course.course2.course1;

/**
 * @author JiazhenZhao
 * 2023/12/16
 * 类说明：
 */
public class Walrus {
    public int length;
    public double weight;

    public Walrus(int length, double weight) {
        this.length = length;
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Walrus{" +
                "length=" + length +
                ", weight=" + weight +
                '}';
    }
}
