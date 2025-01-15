package com.elliot.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubArraySum {

    public static void main(String[] args) {
        System.out.println(bestSolved(new int[]{1,2,3}, 3));
    }

    public static int bestSolved(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int total = 0, count = 0;
        for (int num : nums) {
            total += num;
            if (map.containsKey(total - k)) {
                count += map.get(total - k);
            }
            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return count;
    }


    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
            result += count;
        }
        return result;
    }
}
