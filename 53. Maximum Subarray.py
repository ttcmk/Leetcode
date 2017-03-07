"""
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
"""

# dp问题, 使用dp这个list来存每一次的和，然后每次选出最大值
class Solution(object):
    def maxSubArray(self, nums):
        dp = list()
        dp.append(nums[0])
        Max = dp[0]
        for i in range(1,len(nums)):
            if(dp[i-1] > 0):
                dp.append(nums[i] + dp[i-1])
            else:
                dp.append(nums[i])
            Max = max(Max,dp[i])
        return Max
