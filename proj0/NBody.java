
/**
 * @author JiazhenZhao
 * 2023/12/18
 * 类说明：
 */
public class NBody {
    /**
     * return the radius of fileName.
     *
     * @param fileName file name.
     * @return radius.
     */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int rank = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /**
     * return the all planets  on "fileName".
     *
     * @param fileName file name.
     * @return planet of all planets.
     */
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int rank = in.readInt();
        double radius = in.readDouble();
        Planet[] res = new Planet[5]; // 5 planets.
        for (int i = 0; i < 5; i++) {
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

    /**
     * main() function.
     * @param args arguments.
     */
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        /* Begin draw...        */
        StdDraw.enableDoubleBuffering();
        String imgToDraw = "./images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        /*
        StdDraw.picture(0, 0, imgToDraw);
        StdDraw.show();
        //draw
        for (int i = 0 ; i < planets.length ; i ++){
            planets[i].draw();
            StdDraw.show();
        }
        */
        double time = 0;
        while(time < T) {

            // Create an xForces array and yForces array.
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            // Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively.
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // Call update on each of the planets. This will update each planet’s position, velocity, and acceleration.
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // Draw the background image.
            StdDraw.picture(0, 0, imgToDraw);

            // Draw all the planets.
            for (int i = 0 ; i < planets.length ; i ++){
                planets[i].draw();
            }

            // Show the offscreen buffer (see the show method of StdDraw).
            StdDraw.show();

            // pause
            StdDraw.pause(10);

            // Increase your time variable by dt.
            time += dt;
        }

        // Printing the Universe
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
