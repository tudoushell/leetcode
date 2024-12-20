package com.elliot.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutive {


    public static void main(String[] args) {
        System.out.println(bestSolved(new int[]{100, 4, 200, 1, 3, 2}));
    }

    
    public static int bestSolved(int [] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                //计算总个数  1,2,3
                int sum = left + right + 1;
                map.put(num, sum);
                res = Math.max(res, sum);
                //计算边界
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return res;
    }


    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        List<Integer> longestConsecutive = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i == 0) {
                longestConsecutive.add(num);
                continue;
            }
            int prev = nums[i - 1];
            if (num - prev == 0) {
                continue;
            }
            if (num - prev == 1 || num - prev == -1) {
                longestConsecutive.add(num);
            } else {
                if (maxLength < longestConsecutive.size()) {
                    maxLength = longestConsecutive.size();
                }
                longestConsecutive = new ArrayList<>();
                longestConsecutive.add(num);
            }
        }
        if (!longestConsecutive.isEmpty()) {
            if (maxLength < longestConsecutive.size()) {
                maxLength = longestConsecutive.size();
            }
        }
        return maxLength;
    }
}
