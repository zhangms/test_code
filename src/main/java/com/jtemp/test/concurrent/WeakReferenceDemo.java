package com.jtemp.test.concurrent;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    static class Obj {
        int value;

        public Obj(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Obj:%s", value);
        }
    }

    public static void main(String[] args) {

        Obj obj = new Obj(10);
        WeakReference<Obj> ref = new WeakReference<>(obj);
        while (true) {

            Obj o = ref.get();
            if (o == null) {
                System.out.println("GC cleaned");
            } else {
                System.out.println(o);
            }
        }
    }
}
