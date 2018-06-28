package com.jtemp.test.collection;

public class Demo36 {

    static class Parent {

        public void sayHello() {
            sayHello0();
        }

        public void sayHello0() {
            System.out.println("hello parent");
        }

    }

    static class Child extends Parent {


        @Override
        public void sayHello0() {
            System.out.println("hello child");
        }
    }

    public static void main(String[] args) {

        Parent p = new Child();
        p.sayHello();

    }

}
