package com.chiangshin.arithmetic.exercise;

import java.util.Arrays;
import org.junit.Test;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @Author jx
 * @Date 2021/1/7 0:35
 */
public class TwoSum {
    @Test
    public void test(){
        int[] nums = {1,2,4,5,6,7,8,9};
        System.out.println(Arrays.toString(twoSum(nums, 88)));
    }
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1) return new int[]{};
        for (int i = 0; i < nums.length-1; i++) {
            int res = midSearch(nums, i + 1, target - nums[i]);
            if(res != -1){
                return new int[]{nums[i],res};
            }
        }
        return new int[]{};
    }

    public int midSearch(int[] nums, int pre, int val) {
        int end = nums.length - 1;
        while (pre <= end) {
            int mid = (pre + end) / 2;
            if (nums[mid] == val) {
                return val;
            }
            if (nums[mid] > val) {
                end = mid - 1;
            }
            if (nums[mid] < val) {
                pre = mid + 1;
            }
        }
        return -1;
    }
}
