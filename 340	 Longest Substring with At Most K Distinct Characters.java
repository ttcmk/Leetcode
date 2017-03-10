/*
这道题要求给定一个字符串，然后一个k，求一个最大子串的不重复的字符不大于k的最大子串长度
个人分析：使用hashmap 存储在s中出现的字符，无论出现多少次都设为1；count设为k；
然后在s中设置双指针，left和right，首先right依次向右移动，如果以s[right]为key的在hashmap中的value > 0,则count--,直至count变为负数时，
此时right-left-1 即为当前的最大k个不重复的长度，存入max；
然后left向右移，然后重置right，继续以上步骤，知道right走到s的最后；
*/



package com.ttcmk;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // write your code here

        Solution solution = new Solution();
        int max;
        String s = "aaabcababc";
        int k = 1;
        max = solution.findAnagrams(s, k);
        System.out.println(max);

    }


    public int findAnagrams(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int count = k;
        int left = 0;
        int right = 0;
        int max = 0;

        for(char c: s.toCharArray()){
            if(map.get(c) == null) {
                map.put(c, 1);
            }
        }

        if(count >= map.size()){
            return s.length();
        }

        while(right < s.length()){
            if(map.get(s.charAt(right)) > 0){
                count--;
                map.put(s.charAt(right),0);
            }

            right++;

            if(count < 0){
                int tmpmax = right - left - 1;
                if(tmpmax > max)
                    max = tmpmax;
                left++;
                right = left;
                count = k;

                for(char c: s.toCharArray()){
                    if(map.get(c) == 0) {
                        map.put(c, 1);
                    }
                }
            }
        }

        return max;


    }
}
