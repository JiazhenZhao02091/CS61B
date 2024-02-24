package Homework.Homework2.hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
/**
 * @author JiazhenZhao
 * 2024/2/24
 * 类说明：
 */
public class PercolationStats {
    private PercolationFactory pf;
    private int T;
    private int N;
    private int[] T_x;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException("Argument to less ...");

        this.pf = pf;
        this.T = T;
        this.N = N;
        T_x = new int[T];
    }

    public void experiment(){
        while(T > 0){ // T次实验
            Percolation percolation = pf.make(N);
            int open_size = 0; // 执行 open 操作的次数
            while(percolation.percolates()){
                int x = StdRandom.uniform(N); // (0,N)
                int y = StdRandom.uniform(N); // (0,N)
                if(percolation.isOpen(x, y))
                    continue;
                percolation.open(x,y);
                open_size ++;
            }
            T_x[T -1] = open_size;
            T --;
        }
    }


    // sample mean of percolation threshold
    public double mean() {
        double mean = StdStats.mean(T_x);
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(T_x);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }

}
