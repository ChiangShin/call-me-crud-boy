package com.chiangshin.arithmetic.exercise;

import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @Author jx
 * @Date 2020/11/3 23:31
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String replaceSpace2(String s){
        if (s == null || s.length() == 0){
            return s;
        }

        // 统计空格个数
        int blank = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                blank++;
        }
        if (blank == 0) return s;

        // 替换完之后该字符串的长度
        int length = blank * 2 + s.length();

        char[] arr = new char[length];

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                arr[index] = '%';
                arr[index+1] = '2';
                arr[index+2] = '0';
                index=index+2;
            }else{
                arr[index] = s.charAt(i);
            }
            index++;
        }
        return new String(arr, 0, length);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace2("We are happy."));
    }

}
