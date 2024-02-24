package Homework.Homework2.hw2;

import org.junit.Test;

/**
 * @author JiazhenZhao
 * 2024/2/24
 * 类说明：
 */
public class Percolation_test {

    /** numberOfOpenSites */
    @Test
    public void test(){
        Percolation percolation = new Percolation(4);
        for(int i = 0; i < percolation.size ; i ++)
            for(int j = 0 ; j < percolation.size; j ++)
                percolation.open(i, j);
        System.out.println(percolation.numberOfOpenSites());
    }
    /** percolation */
    @Test
    public void test1(){
        Percolation percolation = new Percolation(4);
        System.out.println(percolation.percolates());
        for(int i = 0; i < percolation.size ; i ++)
            for(int j = 0 ; j < percolation.size; j ++)
                percolation.open(i, j);
        System.out.println(percolation.percolates());
    }

    /** percolation2 */
    @Test
    public void test2(){
        Percolation percolation = new Percolation(4);
        System.out.println(percolation.percolates());
        percolation.open(0,0);
        percolation.open(0,1);
        percolation.open(1,1);
        percolation.open(2,1);
        percolation.open(2,2);
        percolation.open(3,2);
        percolation.printGraph();
        System.out.println(percolation.percolates());
    }
    /** percolation2 */
    @Test
    public void test3(){
        Percolation percolation = new Percolation(4);
        System.out.println(percolation.percolates());
        percolation.open(0,0);
        percolation.open(1,0);
        percolation.open(2,0);
        percolation.open(3,0);
        percolation.printGraph();
        System.out.println(percolation.percolates());
    }
}
