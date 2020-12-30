package com.chiangshin.arithmetic.exercise;

/**
 * @Author jx
 * @Date 2020/12/25 0:11
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if(s == null || "".equals(s)){
            return -1;
        }
        int[] arr = new int[26];
        for(int i = 0; i< s.length();i++){
            int num = s.charAt(i);
            arr[num-97]++;
        }
        for(int i = 0; i< s.length();i++){
            int num = s.charAt(i);
            if(arr[num-97] == 1){
                return i;
            }
        }
        return -1;
    }
}
