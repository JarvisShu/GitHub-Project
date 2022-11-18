package com.binary.bubblle;

import java.util.Arrays;
import java.util.Random;

/**
 * @ProjectName: GitHub-Project
 * @PackageName: com.binary.bubblle
 * @authoer: Jarvis Xu
 * @createDate: 2022/11/18  17:10
 * @description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000) + 1;
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(" =================== ");
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        if (array == null){
            System.out.println(" Please enter an array! ");
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[ j + 1];
                    array[ j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }


}
