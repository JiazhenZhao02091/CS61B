package Homework.Homework2.hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * @author JiazhenZhao
 * 2024/2/24
 * 类说明：
 */
public class Percolation {
    /**
     * graph
     * 0 is blocked
     * 1 is non-blocked
     */
    private int[][] graph;
    private int open_size;
    public int size;

    WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("Argument to less ...");
        graph = new int[N][N];
        weightedQuickUnionUF = new WeightedQuickUnionUF(N);
        open_size = 0;
        size = N;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if(graph[row][col] == 0) {
            graph[row][col] = 1;
            open_size++;
        }
    }

    public boolean isOpen(int row, int col) {
        return graph[row][col] == 1;
    }  // is the site (row, col) open?

    public boolean isFull(int row, int col) {
        return graph[row][col] == 0;
    }  // is the site (row, col) full?

    public int numberOfOpenSites() {
        return open_size;
    }           // number of open sites

    public boolean percolates() {
        boolean[] tmp_flag = new boolean[size];
        tmp_flag[0] = true;
        for(int i = 0 ; i < size - 1; i ++){
            for(int j = 0 ; j < size; j ++){
                if(graph[i][j] == 1 && graph[i+1][j] == 1 && tmp_flag[0]){
                    tmp_flag[i + 1] = true;
                }
            }
        }
        return tmp_flag[size - 1];
    }             // does the system percolate?

    public void printGraph(){
        System.out.println("PRINT GRAPH --- ");
        for (int i = 0 ; i < size; i ++) {
            for (int j = 0; j < size; j++)
                System.out.print(isOpen(i, j) + " ");
            System.out.println();
        }
        System.out.println("--- PRINT END");
    }
    public static void main(String[] args) {

    }   // use for unit testing (not required)



}
