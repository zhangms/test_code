package com.jtemp.test;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "world");
        map.put("world", "hello");
        map.get("world");
        System.out.println(map);

        double i = Math.pow(2, 32);
        System.out.println(i);

        System.out.println(Integer.MAX_VALUE);


    }

}
