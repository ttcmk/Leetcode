/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        //注意if和else if的顺序 最优先判断是不是obstacle，如果不是，再将左边界和上边界初始化，最后用dp求中间的格子
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1){// 将obstacle初始化为0；
                    obstacleGrid[i][j] = 0;
                }
                else if(i == 0 && j == 0){ //在上一步中如果[0][0]是obstacle，为1，则后面的都是0；否则初始化[0][0]为1
                    obstacleGrid[0][0] = 1;
                }
                else if(i == 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] * 1; //如果上边界中左边为0，肯定过不来了，所以0*1 = 0；
                }
                else if(j == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] * 1; //如果左边界的上边是0，肯定也过不来了，所以0*1 = 0；
                }
                else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
    
        return obstacleGrid[m-1][n-1];
    }
}
