"""
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
"""

class Solution(object):
    def generate(self, numRows):
        s = list()
        L = list()
        L.append([1])
        L.append([1,1])
        if numRows == 0:
            return []
        if numRows == 1:
            return [L[0]]
        if numRows == 2:
            for i in range(numRows):
                s.append(L[i])
            return s
        s.append(L[0])
        s.append(L[1])
        for i in range(2,numRows):
            L.append([1])
            for j in range(1,i):
                L[i] += [L[i-1][j-1] + L[i-1][j]]
            L[i] += [1]
            s.append(L[i])
        return s
