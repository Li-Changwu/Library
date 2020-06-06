package com.company;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Library
 * @description:借书线程（消费者）
 * @author: 李长武
 * @create: 2020-06-05 20:41
 **/
public class BorrowThread implements Runnable{
    private BlockingQueue<Book> lib;//书库
    private Random random = new Random();

    public BorrowThread(BlockingQueue<Book> lib) {
        this.lib = lib;
    }

    @Override
    public void run() {
        try {
            synchronized (lib) {
                if (lib.size() == 0) {
                    System.out.println("暂时无书本可借");
                }
                Book t = lib.take();//从书库取出一本书，没有则阻塞等待

                System.out.println(Thread.currentThread().getName() + "借书：" + t + "  剩余" + lib.size() + "本");
            }
            Thread.sleep(random.nextInt(200) + 100);
        } catch (InterruptedException e) {

        }

    }
}
