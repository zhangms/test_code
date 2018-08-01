package com.jtemp.test.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusDemo {

    static class GameEvent {
        long userId;

        String type;

        public GameEvent() {
        }

        public GameEvent(long userId, String type) {
            this.userId = userId;
            this.type = type;
        }

        public long getUserId() {
            return userId;
        }

        public GameEvent setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public String getType() {
            return type;
        }

        public GameEvent setType(String type) {
            this.type = type;
            return this;
        }
    }

    static class GameObject {

        EventBus eventBus = new EventBus();

        long id;

        public GameObject(long id) {
            this.id = id;
            eventBus.register(this);
        }

        public void move() {
            doMove();
            eventBus.post(new GameEvent(id, "move"));
        }

        private void doMove() {
            System.out.println(String.format("%s-%s移动", Thread.currentThread(), id));
        }

        @Subscribe
        public void onEvent(GameEvent event) {
            System.out.println(String.format("%s-%s收到了来自%s的消息%s", Thread.currentThread(), id, event.getUserId(), event.getType()));
            switch (event.getType()) {
                case "move":
                    break;
            }
        }

        public void attach(GameObject g2) {
            eventBus.register(g2);
            g2.eventBus.register(this);
        }
    }

    public static void main(String[] args) {

        GameObject g1 = new GameObject(1);
//        GameObject g2 = new GameObject(2);
//
//        g1.attach(g2);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            g1.move();
//            g2.move();
        }
        long time = System.currentTimeMillis() - start;

        System.out.println(time);

    }

}
