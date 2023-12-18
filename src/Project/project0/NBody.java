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

    /**
     * return the all planets  on "fileName".
     * @param fileName file name.
     * @return planet of all planets.
     */
    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int rank = in.readInt();
        double radius = in.readDouble();
        Planet[] res = new Planet[5]; // 5 planets.
        for(int i = 0 ; i < 5 ; i ++){
            res[i] = new Planet();
            res[i].xxPos = in.readDouble();
            res[i].yyPos = in.readDouble();
            res[i].xxVel = in.readDouble();
            res[i].yyVel = in.readDouble();
            res[i].mass = in.readDouble();
            res[i].imgFileName = in.readString();
        }
        return res;
    }
}
