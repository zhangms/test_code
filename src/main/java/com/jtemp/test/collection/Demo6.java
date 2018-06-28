package com.jtemp.test.collection;

import java.math.BigInteger;

public class Demo6 {

    public static void main(String[] args) {

//        int i = Integer.bitCount(10);
//        System.out.println(i);
//        System.out.println(Integer.toBinaryString(10));

        int len =10;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append('9');
        }
        BigInteger max = new BigInteger(sb.toString());
        System.out.println(max);
        BigInteger one = new BigInteger("1");

        BigInteger value = new BigInteger("0");
        while(value.compareTo(max)<=0){
            System.out.println(value);
            value = value.add(one);
        }


    }

}
