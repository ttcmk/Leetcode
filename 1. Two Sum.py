"""
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""

# O(n)

"""
大体思路：使用一个字典，字典的key = target - nums[i]，代表着还需要多少的数字才能达到target；字典的value是数组中各数字的下标
"""
class Solution(object):
    def twoSum(self, nums, target):
        length = len(nums)
        D = {}
        for i in range(length):
            if nums[i] in D:
                return [D[nums[i]], i]
            else:
                D[target - nums[i]] = i
