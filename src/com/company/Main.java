package com.company;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<Book> lib = new ArrayBlockingQueue<Book>(3);//书库
        lib.offer(new Book(0));//书库初始有一本书

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new ReturnThread(lib));
            exec.execute(new BorrowThread(lib));
        }//产生借书和还书线程

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//sleep 1秒

        exec.shutdownNow();//中断所有线程
    }
}
