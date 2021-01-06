package com.chiangshin.arithmetic.exercise;

/**
 * 实现斐波那契数列
 * @Author jx
 * @Date 2021/1/6 0:13
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(45));
    }
    public static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long pre0 = 0;
        long pre1 = 1;
        long count = 0;
        for(int i = 2; i<=n;i++){
            count = pre0+pre1;
            pre0 = pre1;
            pre1 = count;
        }
        return count;
    }
}
