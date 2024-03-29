package com.liquor.thread.api;

import java.util.concurrent.TimeUnit;

public class SynchronizedDefect {


    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefect defect = new SynchronizedDefect();
        Thread t1 = new Thread(defect::syncMethod);
        t1.start();
        Thread.sleep(2);

        Thread t2 = new Thread(defect::syncMethod);
        t2.start();
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());

    }
}
