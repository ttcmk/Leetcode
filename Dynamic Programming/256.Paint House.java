package com.Dynamic_Programming.Paint_House;

/*
* 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。
* 每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。

费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。

样例
costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

房屋 0 蓝色, 房屋 1 绿色, 房屋 2 蓝色， 2 + 5 + 3 = 10
* */

/*动态规划，如这一次要paint红色，那么之前就paint绿色或者蓝色，找出这两个中的最小值与红色相加*/

public class Solution {

    public static void main(String[] args) {
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};

        int cost = minCost(costs);

        System.out.println(cost);
    }

    public static int minCost(int[][] costs) {
        // Write your code here
        int len = costs.length;
        if(len == 0){
            return 0;
        }
        int preRed = 0;
        int preGreen = 0;
        int preBlue = 0;
        int cost = 0;
        int currentMin = 0;

        for (int i = 0; i < len; i++){
            int tempRed = preRed;
            int tempGreen = preGreen;
            int tempBlue = preBlue;

            preRed = Math.min(tempGreen, tempBlue) + costs[i][0];
            preGreen = Math.min(tempRed, tempBlue) + costs[i][1];
            preBlue = Math.min(tempRed, tempGreen) + costs[i][2];

            if(preRed > preGreen){
                currentMin = Math.min(preGreen,preBlue);
            }
            else{
                currentMin = Math.min(preRed, preBlue);
            }

            cost = currentMin;
        }
        return cost;
    }
}
