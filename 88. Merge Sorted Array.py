"""
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
"""

# nums1 = [1,2,3,0,0,0] m = 3 nums2 = [1,2,4] n = 3; [0,0,0] 是给nums2空出的位置
# 谁大就把谁放到最后
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        insert = m + n - 1
        i = m-1
        j = n-1
        while i >= 0 and j >= 0:
            if nums1[i] <= nums2[j]:
                nums1[insert] = nums2[j]
                insert -= 1
                j -= 1
            else:
                nums1[insert] = nums1[i]
                insert -= 1
                i -= 1
        if j > -1:
            nums1[:j+1] = nums2[:j+1]
