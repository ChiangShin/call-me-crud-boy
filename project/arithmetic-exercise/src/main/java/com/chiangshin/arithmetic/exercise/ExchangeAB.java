package com.chiangshin.arithmetic.exercise;

/**
 * 交换A和B，不使用第三个变量
 */
public class ExchangeAB {

    public static void main(String[] args) {
        int[] dd = exchange(7, 3);
        System.out.printf("%s,%s",dd[0],dd[1]);
    }

    public static int[] exchange(int a ,int b){
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        int[] ss = {a,b};
        return ss;
    }
}
