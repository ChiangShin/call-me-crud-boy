package com.chiangshin.arithmetic;

import org.junit.After;
import org.junit.Test;

/**
 * @Author jx
 * @Date 2021/6/10 0:54
 */
public class SortDemo1 {
    int[] arr = {1,23,32,41,12,3,4,23,2};
    @After
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 冒泡排序
     */
    @Test
    public void mp(){
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    @Test
    public void xz(){
        for (int i = 1; i < arr.length ; i++) {
            for(int j = i ; j < arr.length ; j++){
                if (arr[i-1]>arr[j]) {
                    int tmp = arr[i-1];
                    arr[i-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    @Test
    public void xz2(){
        for (int i = 0; i < arr.length -1; i++) {
            int idx=i;
            for(int j = i+1 ; j < arr.length ; j++){
               if(arr[idx]>arr[j]){
                   idx=j;
               }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
            System.out.println();
        }
    }

    /**
     * 插入排序
     */
    @Test
    public void cr(){
        int pre;
        int cur;
        for (int i = 1; i < arr.length; i++) {
            pre = i-1;
            cur = arr[i];
            while(pre >= 0 && arr[pre] > cur){
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1]= cur;
        }
    }

}
