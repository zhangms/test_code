package com.jtemp.test.collection;

/**
 * 求 1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句（A?B:C）。
 */
public class Demo31 {

    public static void main(String[] args) {

        int n = 100;
//        System.out.println(sumN(n));

        int a=1;
        int b = 2;
        System.out.println(a^b);



    }

    private static int sumN(int n) {
        int sum = n;
        boolean loop = (n > 0) && ((sum += sumN(n - 1))) > 0;
        return sum;
    }

}
