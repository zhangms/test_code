package com.jtemp.test.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortDemo {

    void bubbleSort(int[] array) {
        for (int len = array.length; len >= 0; len--) {
            for (int i = 1; i < len; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
    }

    void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = minIndex(array, i);
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    private int minIndex(int[] array, int start) {
        int min = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }

    void insertionSort(int[] array) {
        int sortedLen = 1;//已排序序列的长度, 默认第0位已加入了排序
        for (int i = 1; i < array.length; i++, sortedLen++) {
            insert(array, sortedLen, i);
        }
    }

    private void insert(int[] array, int sortedLen, int index) {
        for (int i = 0; i < sortedLen; i++) {
            if (array[index] < array[i]) {//i就是要插入的位置
                int val = array[index];//要插入的值
                for (int j = index; j > i; j--) {//往后移
                    array[j] = array[j - 1];
                }
                array[i] = val;
                return;
            }
        }
    }

    int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int index = 0;
        int li = 0;
        int ri = 0;
        while (li < left.length && ri < right.length) {
            if (left[li] < right[ri]) {
                ret[index++] = left[li++];
            } else {
                ret[index++] = right[ri++];
            }
        }
        for (int i = li; i < left.length; i++) {
            ret[index++] = left[i];
        }
        for (int i = ri; i < right.length; i++) {
            ret[index++] = right[i];
        }
        return ret;
    }

    public static void main(String[] args) {

        SortDemo demo = new SortDemo();
        int[] array = initArray();
        print(array);
//        demo.insertionSort(array);
        array = demo.mergeSort(array);
        print(array);
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static int[] initArray() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(100);
        }
        return arr;
    }


}
