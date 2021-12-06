package com.taotao.java;

/**
 * @auther ASUS
 * @date 2021/12/6
 * 使用wait/notify实现线程同步
 */
public class WaitAndNotifySync {

    public static void main(String[] args)throws InterruptedException{
        MyThread myThread = new MyThread();
        synchronized (myThread){
            myThread.start();
            Thread.sleep(3000);
            System.out.println("before wait");
            myThread.wait();
            System.out.println("after wait");


        }
    }
}
