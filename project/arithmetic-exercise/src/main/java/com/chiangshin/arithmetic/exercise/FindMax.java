package com.chiangshin.arithmetic.exercise;

/**
 * 不使用条件语句查找最大的一个数
 */
public class FindMax {

    public static void main(String[] args) {
        System.out.println(findMax(-43, 23));
    }
    public static int findMax(int a, int b){
        int[] arr = {a,b};
        return arr[(a-b)>>>31];
    }
}
