package com.jtemp.test.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {


    static class DelayItem implements Delayed {

        long endTime;
        int second;

        public DelayItem(int second) {
            this.second = second;
            endTime = System.currentTimeMillis() + second * 1000;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(endTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o instanceof DelayItem) {
                DelayItem other = (DelayItem) o;
                return second - other.second;
            }
            return 0;
        }

        @Override
        public String toString() {
            return String.format("DelayItem:%s", second);
        }
    }

    public static void main(String[] args) {
        DelayQueue<DelayItem> delayQueue = new DelayQueue<>();
        for (int i = 9; i > 0; i--) {
            delayQueue.offer(new DelayItem(i));
        }

        while (true) {
            DelayItem item = delayQueue.poll();
            if (item != null) {
                LOG(item);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (delayQueue.isEmpty()) {
                break;
            }
        }


    }

    private static void LOG(DelayItem item) {
        System.out.println(String.format("%s:%s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date()), item));
    }

}
