/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(rowIndex < 0){
            return res;
        }
        
        for(int i=0;i<=rowIndex;i++){
            res.add(0,1);
            for(int j=1;j<=i-1;j++){
                res.set(j, res.get(j) + res.get(j+1));
            }
        }
        return res;
}
}
