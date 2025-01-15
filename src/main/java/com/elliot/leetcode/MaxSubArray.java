package com.elliot.leetcode;

/**
 * leetcode 53
 * <p>
 * Given an integer array nums, find the
 * subarray
 * with the largest sum, and return its sum.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(bestSolved(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    public static int bestSolved(int[] nums) {
        int total = 0;
        int maxValue = nums[0];
        for (int num : nums) {
            if (total < 0) {
                total = 0;
            }
            total += num;
            maxValue = Math.max(maxValue, total);
        }
        return maxValue;
    }

    /**
     * 分治策略
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return calculate(0, nums.length - 1, nums);
    }

    public static int calculate(int low, int high, int[] nums) {
        if (low == high) {
            return nums[low];
        }
        int middle = (low + high) / 2;
        int sum = 0, leftMaxValue = Integer.MIN_VALUE;
        for (int l = middle; l >= low; l--) {
            sum += nums[l];
            leftMaxValue = Math.max(leftMaxValue, sum);
        }
        sum = 0;
        int rightMaxValue = Integer.MIN_VALUE;
        for (int r = middle + 1; r <= high; r++) {
            sum += nums[r];
            rightMaxValue = Math.max(rightMaxValue, sum);
        }
        int maxLeftRight = Math.max(calculate(low, middle, nums), calculate(middle + 1, high, nums));
        return Math.max(maxLeftRight, leftMaxValue + rightMaxValue);
    }
}
