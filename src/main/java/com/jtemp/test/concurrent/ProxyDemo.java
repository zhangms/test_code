package com.jtemp.test.concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {

    interface Sprite {

        void move();

    }

    public static void main(String[] args) {

        Sprite sprite = (Sprite) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{Sprite.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("move".equals(method)) {
                    System.out.println("---begin move---");
                    method.invoke(proxy, args);
                    System.out.println("---end move---");
                }
                return null;
            }
        });

        sprite.move();


    }

}
