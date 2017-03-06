"""
Two pointer: 遇到大于value的数就覆盖到等于value的数
"""

class Solution(object):
    def removeElement(self, nums, val):
        if not nums:
            return 0
        
        j = 0
        nums.sort()
        for i in range(0,len(nums)):
            if nums[i] < val:
                j += 1
                continue
            if nums[i] != val:
                nums[j] = nums[i]
                j += 1
        return j
