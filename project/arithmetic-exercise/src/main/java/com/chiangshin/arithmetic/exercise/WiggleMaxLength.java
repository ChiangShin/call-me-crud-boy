package com.chiangshin.arithmetic.exercise;

/**
 * @Author jx
 * @Date 2020/12/13 19:09
 */
public class WiggleMaxLength {

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int j = 2;
        while(j<nums.length){
            if((nums[j] > nums[j-1] && nums[j-1] > nums[j-2]) || (nums[j] < nums[j-1] && nums[j-1] < nums[j-2])){
                break;
            }
            j++;
        }
        return j;
    }
}
