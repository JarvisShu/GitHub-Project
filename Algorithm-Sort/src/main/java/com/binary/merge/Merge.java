package com.binary.merge;

import java.util.Arrays;
import java.util.Random;

/**
 * @ProjectName: GitHub-Project
 * @PackageName: com.binary.merge
 * @authoer: Jarvis Xu
 * @createDate: 2022/11/18  22:12
 * @description:
 */
public class Merge {
    public static void main(String[] args) {
       int[] array = new int[9];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1 ;
        }
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("==============");
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        int len = array.length;
        int[] result = new int[len];
        mergeRecursive(array,result,0,len - 1);
    }

    private static void mergeRecursive(int[] array, int[] result, int start,
                                       int end) {
        if (array == null || result == null)
            return;
        if (start >= end)
            return;
        int len = end - start;
        int mid = start + len / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        // TODO 递归调用将元素进一步打散
        mergeRecursive(array, result, start1, end1);
        mergeRecursive(array, result, start2, end2);
        int base = start;
        while (start1 <= end1 && start2 <= end2){
            result[base++] = array[start1] < array[start2] ? array[start1++]
                    : array[start2++];
        }
        while (start1 <= end1){
            result[base++] = array[start1++];
        }
        while (start2 <= end2){
            result[base++] = array[start2++];
        }
        for (base = start;base <= end;base++){
            array[base] = result[base];
        }
    }


}
