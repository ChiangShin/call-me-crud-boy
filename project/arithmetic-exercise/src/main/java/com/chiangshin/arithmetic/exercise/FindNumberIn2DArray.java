package com.chiangshin.arithmetic.exercise;

/**
 * 在一个二维数组中，每一含都按照从左到右递增的顺序排序，每一行都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该函数。
 * @Author jx
 * @Date 2021/1/11 20:35
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray(matrix, 5));
    }
    public static boolean findNumberIn2DArray(int[][] matrix,int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int cols = matrix.length;
        int rows = matrix[0].length;

        int col = cols -1 ;
        int row = 0;
        while(col >= 0 && row < rows){
            if(matrix[col][row] > target){
                col--;
            }else if(matrix[col][row] < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}
