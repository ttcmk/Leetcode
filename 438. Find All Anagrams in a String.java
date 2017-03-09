/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[128];
        
        for(char c: p.toCharArray()){
            hash[c]++;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right < s.length()){
            if(hash[s.charAt(right)] >= 1) //这个字母与p中的某一个字母匹配
                count--;
            
            hash[s.charAt(right)]--; //所有的值都-1
            right++; //right向右移
            
            if(count == 0) //count由3减到0，说明3个不同的字母都匹配了
                res.add(left);
            
            if(right - left == p.length()){ //此时已经匹配了3次，应该除去最左边的那个字母，sliding window向右移一位
                if(hash[s.charAt(left)] >= 0) //如果将要除去的最左边的字母之前被计算过，count应该加回去
                    count++;
                
                hash[s.charAt(left)]++; //把将要除去的字母的hash数组的值加1，防止之后的与之相同的值出现时出现错误
                left++;
            }
        }
        
        return res;
    }
}
