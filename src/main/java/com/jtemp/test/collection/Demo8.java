package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 */
public class Demo8 {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(ThreadLocalRandom.current().nextInt(100));
        }

        System.out.println(list);
        list.sort((o1, o2) -> {
            boolean v1 = o1 % 2 == 0;
            boolean v2 = o2 % 2 == 0;
            if (v1 == v2) {
                return 0;
            }
            return v1 ? 1 : -1;
        });

        System.out.println(list);

    }


}
