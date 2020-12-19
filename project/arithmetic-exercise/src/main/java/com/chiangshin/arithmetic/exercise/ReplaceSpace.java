package com.chiangshin.arithmetic.exercise;

/**
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

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {

        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;

    }

    public static int search(int[] nums, int target) {
        int num = 0;
        for(int i = 0; i< nums.length;i++){
            if(nums[i]> target){
                return num;
            }else if(nums[i] == target){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] ss = {1,3,42,3,35,24,23,35,3};
        System.out.println(search(ss,3));

    }

}
