/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*
要考虑4种情况：
1. 第i个数可以和前一个数组合，也可以自己单独出现 ===> 前两个数dp值之和；
2. 第i个数只能和前一个数组合，不能自己单独出现 ===> i-2的dp值；
3. 第i个数不能和前一个数组合，只能自己单独出现 ===> i-1的dp值；
4. 不能接受的情况为：第i个数为0，前一个数也为0或大于2 ===> 既不能自己出现，也不能组合，直接返回0；
*/

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        
        if(len == 0) 
            return 0;
        if(s.charAt(0) == '0') 
            return 0;
        
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=1;i<len;i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) > '2' || s.charAt(i-1) == '0'){ //既不能组合也不能自立门户
                    return 0;
                }
                else{ //为1，2时,只能是10或者20，必须和前一个数成对出现，所以等于再前面一个数的dp值；
                    dp[i+1] = dp[i-1];
                }
            }
            else if(s.charAt(i) >= '1' && s.charAt(i) <= '6'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    //前面的是1或者2，i不仅可以成对，也可以自己出现，所以是前两个数的组合个数的和；
                    dp[i+1] = dp[i] + dp[i-1];
                }
                else{//前面是0或者大于2的数，不能和i成对出现，所以只能自己出现（一种），所以等于前一个数的组合个数；
                    dp[i+1] = dp[i]; 
                }
            }
            else{//s.charAt(i) == 7~9,当前面是1时，可以成对，也可以自己出现（和）；当前面不是1时，只能自己出现（一种）；
                if(s.charAt(i-1) == '1'){
                    dp[i+1] = dp[i] + dp[i-1];
                }
                else{
                    dp[i+1] = dp[i];
                }
            }
        }
        
        return dp[len];
    }
}
