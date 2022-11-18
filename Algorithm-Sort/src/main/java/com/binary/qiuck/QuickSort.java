package com.binary.qiuck;

import java.util.Arrays;
import java.util.Random;

/**
 * @ProjectName: GitHub-Project
 * @PackageName: com.binary.qiuck
 * @authoer: Jarvis Xu
 * @createDate: 2022/11/18  21:33
 * @description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(" ------------- ");
        quickSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (array == null){
            System.out.println("please enter an array!");
            return;
        }
        if (start >= end){
            return;
        }
        int left = start;
        int right = end;
        int flag = array[start];
        while (left < right){
            // TODO 开始从右边找标志位小的元素
            while (left < right && array[right] > flag){
                right--;
            }
            // 找到了比标志位小的元素
            if (left < right){
                array[left++] = array[right];
            }
            // TODO 之后在从左边找比标志位大的元素
            while (left < right && array[left] < flag){
                left++;
            }
            // 找到了比标志位大的元素
            if (left < right){
                array[right--] = array[left];
            }
        }
        // 左右开始碰撞 left = right
        array[left] = flag;
        // TODO 标志位归位后，两边继续进行递归比较，但是中间的标志位不需要参与递归调用，因为标志位已经归位了
        quickSort(array, start, left-1);
        quickSort(array, left + 1, end);
    }
}
