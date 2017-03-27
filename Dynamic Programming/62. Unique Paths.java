/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int res = 0;
        int[][] path = new int[m][n];

        if(m == 1 || n == 1){
            return 1;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0){
                    path[0][j] = 1;
                }
                else if(j == 0){
                    path[i][0] = 1;
                }
                else{
                    path[i][j] = path[i][j-1] + path[i-1][j];
                }
            }
        }

        return path[m-1][n-1];
    }
}

