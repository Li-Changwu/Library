package com.company;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Library
 * @description: 还书线程（生产者）
 * @author: 李长武
 * @create: 2020-06-05 20:42
 **/
public class ReturnThread implements Runnable{
    private BlockingQueue<Book> lib;//书库
    private Random random = new Random();
    private static AtomicInteger order = new AtomicInteger();//用于生成书编号

    public ReturnThread (BlockingQueue<Book> lib) {
        this.lib = lib;
    }

    @Override
    public void run() {
        try {
            Book book = new Book(order.incrementAndGet());
            synchronized (lib){

                if(lib.offer(book) == false){
                    System.out.println(Thread.currentThread().getName() + "书库已满");
                    return;
                }else{
                    System.out.println(Thread.currentThread().getName() + "还书：" + book + "  剩余" + lib.size() + "本");
                }
            }

            Thread.sleep(random.nextInt(200)+100);
        } catch (InterruptedException e){

        }
    }
}
