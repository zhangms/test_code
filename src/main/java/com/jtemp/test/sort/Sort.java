package com.jtemp.test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sort {

    /**
     * 冒泡排序
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable> void bubbleSort(List<T> list) {
        int len = list.size();
        boolean exchanged = true;
        while (len > 0 && exchanged) {
            exchanged = false;
            for (int i = 0; i < len - 1; i++) {
                T o1 = list.get(i);
                T o2 = list.get(i + 1);
                if (o1.compareTo(o2) > 0) {
                    T tmp = o1;
                    list.set(i, o2);
                    list.set(i + 1, tmp);
                    exchanged = true;
                }
            }
            System.out.println(list);
            len--;
        }
    }


    /**
     * 选择排序
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable> void selectionSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T minValue = list.get(i);
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                T o = list.get(j);
                if (minValue.compareTo(o) > 0) {
                    minValue = o;
                    minIndex = j;
                }
            }
            list.set(minIndex, list.get(i));
            list.set(i, minValue);
            System.out.println(list);
        }
    }


    /**
     * 插入排序
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable> void insertionSort(List<T> list) {
        int len = list.size();
        for (int i = 1; i < len; i++) {
            T cur = list.get(i);
            for (int j = 0; j < i; j++) {
                T val = list.get(j);
                if (cur.compareTo(val) <= 0) {
                    list.add(j, cur);
                    if (list.size() > i + 1) {
                        list.remove(i + 1);
                    }
                    break;
                }
            }
            System.out.println(list);
        }
    }

    /**
     * 归并排序
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable> List<T> mergeSort(List<T> list) {
        int len = list.size();
        if (len < 2) {
            return list;
        }
        int middle = len / 2;
        List<T> left = new ArrayList<>(list.subList(0, middle));
        List<T> right = new ArrayList<>(list.subList(middle, len));
        return merge(mergeSort(left), mergeSort(right));
    }

    private static <T extends Comparable> List<T> merge(List<T> left, List<T> right) {
        List<T> ret = new ArrayList<>();

        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0).compareTo(right.get(0)) < 0) {
                ret.add(left.remove(0));
            } else {
                ret.add(right.remove(0));
            }
        }

        while (left.size() > 0) {
            ret.add(left.remove(0));
        }

        while (right.size() > 0) {
            ret.add(right.remove(0));
        }
        return ret;
    }


    public static <T extends Comparable> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable> void quickSort(List<T> list, int left, int right) {
        if (left < right) {
            int index = quickSortPartition(list, left, right);
            quickSort(list, left, index - 1);
            quickSort(list, index + 1, right);
        }
    }

    private static <T extends Comparable> int quickSortPartition(List<T> list, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (list.get(i).compareTo(list.get(pivot)) < 0) {
                Collections.swap(list, i, index);
                index++;
            }
        }
        Collections.swap(list, pivot, index - 1);
        return index - 1;
    }


    private static List<Integer> randomList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = randomList();
        System.out.println(list);
//        Sort.bubbleSort(list);
//        Sort.selectionSort(list);
//        insertionSort(list);
//        list = mergeSort(list);
        quickSort(list);
        System.out.println(list);
    }
}
