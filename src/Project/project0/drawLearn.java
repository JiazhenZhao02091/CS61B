package Project.project0;

/**
 * @author JiazhenZhao
 * 2023/12/19
 * 类说明：
 */
public class drawLearn {
    public static void main(String[] args) {
        /*
        // 5% border
        StdDraw.setScale(-0.05, 1.05);

        // draw the triangle
        double t = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);

        // draw the point; make pen radius large enough to see it
        StdDraw.setPenRadius(0.01);
         */
        // initial values
        double rx = 0.480, ry = 0.860;     // position
        double vx = 0.015, vy = 0.023;     // velocity
        double radius = 0.05;              // radius

        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        while (true) {
            // update position
            rx = rx + vx;
            ry = ry + vy;

            // set the background to light gray
            StdDraw.clear(StdDraw.LIGHT_GRAY);

            // draw ball on the screen
            StdDraw.picture(rx, ry, "TennisBall.gif");

            // display and pause for 20ms
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}

