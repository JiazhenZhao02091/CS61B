package Project.project0;

/**
 * @author JiazhenZhao
 * 2023/12/18
 * 类说明：
 */
public class NBody {
    /**
     * return the radius of fileName.
     * @param fileName file name.
     * @return radius.
     */
    public static double readRadius(String fileName){
        In in = new  In(fileName);
        int rank = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
}
