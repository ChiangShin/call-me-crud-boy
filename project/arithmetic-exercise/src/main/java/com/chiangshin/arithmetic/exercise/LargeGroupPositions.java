package com.chiangshin.arithmetic.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jx
 * @Date 2021/1/6 0:24
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzzzytttt"));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        int length = s.length();
        int count = 1;

        for (int i = 1; i < length; i++) {
            if ((i == length - 1 || s.charAt(i) != s.charAt(i - 1)) && count >= 3) {
                List<Integer> subList = new ArrayList<Integer>();
                subList.add(i);
                subList.add(i + count - 1);
                resList.add(subList);
                count = 1;
            } else {
                count++;
            }
        }
        return resList;
    }

}
