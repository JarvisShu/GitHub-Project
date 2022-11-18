package com.binary.research;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @ProjectName: GitHub-Project
 * @PackageName: com.binary.research
 * @authoer: Jarvis Xu
 * @createDate: 2022/11/18  23:06
 * @description:
 */
public class BinaryResearch {
    public static void main(String[] args) {
        int[] array = new int[15];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1 ;
        }
        // TODO 二分查找要求数组有序
        quickSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
        int ran = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        int target = 0;
        if (in < 0){
            target = ran;
        } else {
            target = in;
        }
        System.out.println("target = " + target);
        int answer =  binarySearch(array,target);
        System.out.println("answer = " + answer);
    }
    private static int binarySearch(int[] array, int target) {
        if (array == null){
            return -1;
        }
        int start = 0;
        int end = array.length -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (array[mid] == target){
                return target;
            }else if (target < array[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
    private static void quickSort(int[] array, int start, int end) {
        if (array == null) {
            System.out.println("please enter an array!");
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int flag = array[start];
        while (left < right) {
            // TODO 开始从右边找标志位小的元素
            while (left < right && array[right] > flag) {
                right--;
            }
            // 找到了比标志位小的元素
            if (left < right) {
                array[left++] = array[right];
            }
            // TODO 之后在从左边找比标志位大的元素
            while (left < right && array[left] < flag) {
                left++;
            }
            // 找到了比标志位大的元素
            if (left < right) {
                array[right--] = array[left];
            }
        }
        // 左右开始碰撞 left = right
        array[left] = flag;
        // TODO 标志位归位后，两边继续进行递归比较，但是中间的标志位不需要参与递归调用，因为标志位已经归位了
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }
}
