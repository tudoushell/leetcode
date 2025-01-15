package com.elliot.leetcode;

/**
 * leetcode 76
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    
    public static String minWindow(String s, String t) {
        //A D O B E C O D E B A  N  C
        //0 1 2 3 4 5 6 7 8 9 10 11 12
        if (s == null || t == null || s.isEmpty() || t.isEmpty()
                || s.length() < t.length()) {
            return "";
        }
        int[] tCharArr = new int[128];
        for (char tChar : t.toCharArray()) {
            tCharArr[tChar]++;
        }
        char[] sCharArr = s.toCharArray();
        //匹配的数量
        int count = t.length();
        int start = 0;
        int end = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (tCharArr[sCharArr[end++]]-- > 0) {
                count--;
            }
            //找到所有符合条件的字符串
            while (count == 0) {
                //缩小划动窗口
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (tCharArr[sCharArr[start++]]++ == 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : new String(sCharArr, startIndex, minLen);
    }
}
