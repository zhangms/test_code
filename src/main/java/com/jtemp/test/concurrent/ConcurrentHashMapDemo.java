package com.jtemp.test.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class ConcurrentHashMapDemo {

    static class AtomicDemo {
        protected volatile String game;

        public String getGame() {
            return game;
        }

        public AtomicDemo setGame(String game) {
            this.game = game;
            return this;
        }
    }

    public static void main(String[] args) {

        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.set(9, 10);
        System.out.println(array);

        AtomicReferenceArray<String> ref = new AtomicReferenceArray<>(10);
        ref.set(1, "ff");

        AtomicReferenceFieldUpdater<AtomicDemo, String> updater = AtomicReferenceFieldUpdater.newUpdater(AtomicDemo.class, String.class, "game");

        AtomicDemo demo = new AtomicDemo();
        demo.setGame("hello");

        updater.set(demo, "world");

        System.out.println(demo.getGame());
    }

}
