"""
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
"""
# one solution:
class Solution(object):
    def searchInsert(self, nums, target):
        if nums[-1] < target:
            return len(nums)
        else:
            for i in range(len(nums)):
                if nums[i] == target:
                    return i
                if nums[i] > target:
                    return i


# second solution using binary search:
class Solution(object):
    def searchInsert(self, nums, target):
        if target <= nums[0]:
            return 0
            
        if target > nums[len(nums) - 1]:
            return len(nums)

        start, end = 0, len(nums) - 1
        while start <= end:
            mid = (start + end)/2
            if nums[mid] > target:
                end = mid - 1
                if end >= 0:
                    if nums[end] < target: #同下
                        return end + 1
                else:
                    return 0
    
            elif nums[mid] < target:
                start = mid + 1
                if start < len(nums):
                    if nums[start] > target: #important for example[1 5 6 9] target = 7; 如果没有这句，出错
                        return start
                else:
                    return len(nums)
            else:
                return mid
