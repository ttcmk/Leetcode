//给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
//只能往下走和往右走
/*

public class Solution {
    public int minPathSum(int[][] grid) {
        int min = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    continue;
                }
                else if(i == 0){ //由于只能向下走和向右走，所以最左列和最上行初始化为自己和上一个的和
                    grid[i][j] += grid[i][j-1];
                }
                else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }
                else{ //其余的格子的值为自己的值加上上面格子和左边格子的最小值即可，每次都算出最小值
                    grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
