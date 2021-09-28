package com.solvd.askomar.mergesort;

import java.util.Arrays;

public class MergeSortTask {

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[leftArray.length + rightArray.length];
        for(int i = 0, leftIndex = 0, rightIndex = 0; i < leftArray.length + rightArray.length; i++) {
           if(leftIndex == leftArray.length) {
               resultArray[i] = rightArray[rightIndex];
               rightIndex++;
           } else if(rightIndex == rightArray.length) {
               resultArray[i] = leftArray[leftIndex];
               leftIndex++;
           } else {
               if(leftArray[leftIndex] <= rightArray[rightIndex]) {
                   resultArray[i] = leftArray[leftIndex];
                   leftIndex++;
               } else {
                   resultArray[i] = rightArray[rightIndex];
                   rightIndex++;
               }
           }
        }
        return resultArray;
    }

    public static int[] mergeSort(int[] array){
        if(array == null || array.length < 2) {
            return array;
        }
        int[] rightArray = new int[array.length / 2];
        int[] leftArray = new int[array.length - array.length / 2];

        System.arraycopy(array, 0, rightArray, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, leftArray, 0, array.length - array.length / 2);

        rightArray = mergeSort(rightArray);
        leftArray = mergeSort(leftArray);

        return merge(rightArray, leftArray);
    }

    public static void main(String[] args) {
        int[] testArray = new int[] {4, 3, 9, 10, 2, 2, 9, 7, 9, 10};
        int[] sortedArray = mergeSort(testArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}
