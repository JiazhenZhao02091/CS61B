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
     * @param p the other planet.
     * @return r mean the distance.
     */
    public double calcDistance(Planet p){
        double r = (xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos);
        r = Math.sqrt(r);
        return r;
    }

    /**
     * returns a double var, the force between This planet and the Planet p.
     * @param p other planet p.
     * @return force between the Planet ant the Planet p.
     * calc formula: F = G * m1 * m2 / r^2;=6.67⋅10 -11
     */
    public double calcForceExertedBy(Planet p){
        double F = mass * p.mass;
        double r = calcDistance(p);
        double G = 6.67e-11;
        F = F * G / (r * r);
        return F;
    }

    /**
     * returns the force in x direction.
     * @return
     * F = f * dx / r
     */
    public double calcForceExertedByX(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        double ForceByX = F * dx / r;
        return ForceByX;
    }

    /**
     * returns the force in y direction.
     * @param p other planet
     * @return
     * F = f * dy / r
     */
    public double calcForceExertedByY(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        double ForceByY = F * dy / r;
        return ForceByY;
    }

    /**
     * return the all net force in x for This planet.
     * @param planets all planets.
     * @return the force in x direction.
     */
    public double calcNetForceExertedByX(Planet[] planets){
        double ForceX = 0;
        for(int i = 0 ; i < planets.length ; i ++)
        {
            if(planets[i].equals(this))
                continue;
            ForceX += this.calcForceExertedByX(planets[i]);
        }
        return ForceX;
    }

    /**
     * return the all net force in 'y' for This planet.
     * @param planets all planets.
     * @return the force in 'y' direction.
     */
    public double calcNetForceExertedByY(Planet[] planets){
        double  ForceY = 0 ;
        for(int i = 0 ; i < planets.length ; i ++)
        {
            if(planets[i].equals(this))
                continue;
            ForceY += this.calcForceExertedByY(planets[i]);
        }
        return ForceY;
    }
}
