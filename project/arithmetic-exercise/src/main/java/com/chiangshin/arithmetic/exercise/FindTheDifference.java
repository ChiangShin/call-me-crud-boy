package com.chiangshin.arithmetic.exercise;

import org.junit.Test;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] tArr = t.toCharArray();

        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < tArr.length; j++) {
                if (tArr[j] == s.charAt(i)){
                    if(i==j){
                        break;
                    }
                    char tmp = tArr[j];
                    tArr[j] = tArr[i];
                    tArr[i] = tmp;
                    break;
                }
            }
        }
        return tArr[tArr.length-1];
    }

    /**
     * 官方解法1
     * 全部只有小写字母，有26个字母，可以全部放到数组中
     * 字符 'a' = 97
     */
    public char fun1(String s, String t){
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 96;
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 96;
            arr[index]--;
            if(arr[index] == -1){
                return (char)(index +96);
            }
        }
        return 'a';
    }
    /**
     * 官方解法2
     * 字符串每个字符之和减去另一个字符串字符之和，等于ascii码码值。
     */
    public char fun2(String s, String t){
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }
        return (char)sum;
    }
    /**
     * 官方解法2
     * 两个字符串合起来位运算，等于ascii码码值。
     * 2^4^2 =  4
     */
    public char fun3(String s, String t){
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum ^= t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum ^= s.charAt(i);
        }
        return (char)sum;
    }

    @Test
    public void ss(){
        System.out.println(fun3("bdd", "ddwb"));
    }



}
