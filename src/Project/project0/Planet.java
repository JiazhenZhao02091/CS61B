package Project.project0;

/**
 * @author JiazhenZhao
 * 2023/12/15
 * 类说明：
 */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * 构造函数，如果参数选择和变量一样的名字，必须要使用 this keyword
     * eg: this.mass = mass;
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass  = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /**
     * returns a double var that mean this planet and the 'p' planet distance.
     * @param p
     * @return
     */
    public double calcDistance(Planet p){
        double r = (xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos);
        r = Math.sqrt(r);
        return r;
    }
}
