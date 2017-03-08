"""
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
"""

# 要考虑【8，9，9，9】的情况 和 【9，9，9】的情况
class Solution(object):
    def plusOne(self, nums):
        n = len(nums)
        if (nums[n-1] == 9):
            j = n-1
            while nums[j] == 9:
                nums[j] = 0
                j -= 1
                if j < 0:
                    N = [1] + nums
                    return N
            nums[j] += 1
            return nums
        return nums[:n-1] + [nums[n-1] + 1]
