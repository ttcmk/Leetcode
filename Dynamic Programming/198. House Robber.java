/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        int preNo = 0; //不抢上一家能拿到的最大钱数
        int preYes = 0;//抢了上一家能拿到的钱数

        for(int i=0;i<nums.length;i++){
            int tmp = preNo;
            preNo = Math.max(preNo, preYes); //这家我不抢，则拿到多最大钱数是上一家抢和上一家不抢的最大值
            preYes = nums[i] + tmp; //这家我抢的话，上一家就肯定不能抢
        }
        
        return Math.max(preNo,preYes);
    }
}
