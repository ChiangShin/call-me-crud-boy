package com.chiangshin.arithmetic;

public class Test {

    public static void main(String[] args) {
        int[] nums = {9, 3, 5, 1};

        selectSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void selectSortV1(int[] nums) {

        int pre = 0, end = nums.length-1;
        int min=nums[pre], max=nums[end];
        int cur;
        while (pre >= end) {
            cur = pre;
            while(cur == end){
                min = min < nums[cur]?min: nums[cur];
                min = max < nums[cur]?min: nums[cur];
                cur++;
            }
            pre++;
            end--;
        }
    }


    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        swap(nums, left, mid);

        int cur = left;
        for (int i = left + 1; i < right - 1; i++) {
            if (nums[left] > nums[i]) {

            }
        }

    }

}
