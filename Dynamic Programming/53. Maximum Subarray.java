/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        
        dp[0] = nums[0];
        int MAX = dp[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(nums[i] + dp[i-1], nums[i]);
            MAX = Math.max(MAX,dp[i]);
        }
        return MAX;
    }
}
