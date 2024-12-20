package com.elliot.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 438
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams
 * in s. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class FindAnagrams {

    public static void main(String[] args) {
        //yqrbgjdwtcaxzsnifvhmou
        //abab ab
        anagrams("abab", "ab").stream().forEach(System.out::println);
    }


    public static List<Integer> test(String s, String p) {
        int[] sCountArr = new int[26];
        int[] pCountArr = new int[26];
        for (char c : p.toCharArray()) {
            pCountArr[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            sCountArr[s.charAt(right) - 'a']++;
             left = right - p.length() + 1;
            if (left < 0) {
               continue;
            }
            if (Arrays.equals(sCountArr,pCountArr)) {
                result.add(left);
            }
            sCountArr[s.charAt(left) - 'a']--;
        }
        return result;
    }
    



    public static List<Integer> anagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCountArr = new int[26];
        for (char pChar : p.toCharArray()) {
            pCountArr[pChar - 'a']++;
        }
        int[] sCountArr = new int[26];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            sCountArr[s.charAt(right) - 'a']++;
            left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(pCountArr, sCountArr)) {
                result.add(left);
            }
            sCountArr[s.charAt(left) - 'a']--;
        }
        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        //0123456789
        //cbaebabacd
        //left right
        //01234
        //axfax
        //
        int left = 0;
        int searchCount = 0;
        StringBuilder waitEqualData = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        String sortedP = new String(pCharArray);
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (p.indexOf(rightChar) != -1) {
                waitEqualData.append(rightChar);
                searchCount++;
            } else {
                waitEqualData = new StringBuilder();
                searchCount = 0;
                right = left;
                left++;
            }
            if (searchCount == p.length()) {
                char[] waitCompareStr = waitEqualData.toString().toCharArray();
                Arrays.sort(waitCompareStr);
                if (new String(waitCompareStr).equals(sortedP)) {
                    result.add(left);
                }
                right = left;
                left++;
                waitEqualData = new StringBuilder();
                searchCount = 0;
            }
        }
        return result;
    }

}
