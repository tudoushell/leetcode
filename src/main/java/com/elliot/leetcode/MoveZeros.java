package com.elliot.leetcode;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        moveZeroes(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
