"""
将一个数组中不同的那个数放到A[j],j应该先+1；注意i是从1开始的
"""
class Solution(object):
    def removeDuplicates(self, nums):
        if not nums:
            return 0

        j = 0

        for i in range(1, len(nums)):
            if A[i] != A[j]:
                j += 1
                A[j] = A[i]

        return newTail + 1
        
