package Homework.Homework3.hash;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
/**
 * @author JiazhenZhao
 * 2024/2/25
 * 类说明：
 */


public class SimpleOomage implements Oomage {
    protected int red;
    protected int green;
    protected int blue;

    private static final double WIDTH = 0.01;
    private static final boolean USE_PERFECT_HASH = true;

    @Override
    public boolean equals(Object o) {
        // TODO: Write this method.
        // use the function that named getClass
        if(!o.getClass().equals(SimpleOomage.class))
            return false;
        if(this.red == ((SimpleOomage) o).red
           && this.blue == ((SimpleOomage) o).blue
        && this.green == ((SimpleOomage) o).green)
            return true;
        return false;
    }

    /* Uncomment this method after you've written
       equals and failed the testHashCodeAndEqualsConsistency
       test.
       */
    @Override
    public int hashCode() {
        if (!USE_PERFECT_HASH) {
            return red + green + blue;
        } else {
            // TODO: Write a perfect hash function for Simple Oomages.
            /**
             * red
             * blue
             * green
             */
            /*
            double weight_red = red * 0.2;
            double weight_blue = blue * 0.3;
            double weight_green = green * 0.4;
            return (int) ((weight_green + weight_red + weight_green) % 3);
             */
            red = red / 5;
            blue = blue / 5;
            green = green / 5;
            return (red * 2 + green * 3 + blue * 4) % ((red + green + blue) / 2);
        }
    }

    public SimpleOomage(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException();
        }
        if ((r % 5 != 0) || (g % 5 != 0) || (b % 5 != 0)) {
            throw new IllegalArgumentException("red/green/blue values must all be multiples of 5!");
        }
        red = r;
        green = g;
        blue = b;
    }

    @Override
    public void draw(double x, double y, double scalingFactor) {
        StdDraw.setPenColor(new Color(red, green, blue));
        StdDraw.filledSquare(x, y, WIDTH * scalingFactor);
    }

    public static SimpleOomage randomSimpleOomage() {
        int red = StdRandom.uniform(0, 51) * 5;
        int green = StdRandom.uniform(0, 51) * 5;
        int blue = StdRandom.uniform(0, 51) * 5;
        return new SimpleOomage(red, green, blue);
    }

    public static void main(String[] args) {
        System.out.println("Drawing 4 random simple Oomages.");
        randomSimpleOomage().draw(0.25, 0.25, 1);
        randomSimpleOomage().draw(0.75, 0.75, 1);
        randomSimpleOomage().draw(0.25, 0.75, 1);
        randomSimpleOomage().draw(0.75, 0.25, 1);
    }

    public String toString() {
        return "R: " + red + ", G: " + green + ", B: " + blue;
    }
} 
