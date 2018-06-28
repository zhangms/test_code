package com.jtemp.test.collection;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class Demo26 {

    public static void main(String[] args) {

//        String str = "I am a student.";
//
//        String ret = Arrays.stream(str.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
//            Collections.reverse(list);
//            return list.stream();
//        })).collect(Collectors.joining(" "));

//        System.out.println(ret);

        BloomFilter<String> filter = BloomFilter.create(Funnels.unencodedCharsFunnel(), 1000);
        filter.put("FFF");
        filter.put("xxx");
        System.out.println(filter.mightContain("xxx"));
    }

}
