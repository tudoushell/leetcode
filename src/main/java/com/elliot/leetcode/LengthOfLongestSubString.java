package com.elliot.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3
 * <p>
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));


    }

    public static int lengthOfLongestSubstring(String s) {
        //01234567
        //abcabcbb
        //a:1 b:1 c:1
        //left = 0 right = 2
        //length = right - left + 1
        //max = 3
        //a:1,b:1 c:1
        //bca max 3
        //a:1 b:1 c:1
        //012345
        //pwwkew
        //p:1  max:1  left:0 right:0  p
        //p:1 w:1 max:2   left:0 right:1 w
        //p:0 w:1 max:1 left:2 right:2  w  left right equal:
        //p:0 w:1 k:1 max:2 left:1
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> dataCountMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char data = s.charAt(right);
            dataCountMap.put(data, dataCountMap.getOrDefault(data, 0) + 1);
            while (dataCountMap.get(data) > 1) {
                char leftData = s.charAt(left);;
                dataCountMap.put(leftData, dataCountMap.get(leftData) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
