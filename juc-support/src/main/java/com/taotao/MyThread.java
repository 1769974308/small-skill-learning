package com.taotao;

/**
 * @auther ASUS
 * @date 2021/12/6
 */
public class MyThread  extends  Thread{


    @Override
    public void run() {
        synchronized (this){
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}
