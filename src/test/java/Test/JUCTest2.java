package Test;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache2 {

    // 使用volatile关键字，保证了变量的可见性。
    // 被volatile关键字修饰的变量，如果值发生了变更，其他线程立马可见，避免出现脏读的现象。
    private volatile HashMap<String, Object> map = new HashMap<>();

    // 存写
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName()+"正在写入"+key+":"+value);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完毕");
    }

    // 读取
    public void get(String key) {
        System.out.println(Thread.currentThread().getName()+"正在读取"+key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完毕");
    }
}


/**
 * 加锁的自定义缓存
 */
class MyCacheLock2 {
    private volatile HashMap<String,Object> map=new HashMap<>();
    //读写锁,更加细腻度的控制
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    //存写 (存写的时候只希望有一个线程进行)
    public void put(String key, Object value) {
        //上一把写锁
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入"+key+":"+value);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完毕");
        } finally {
            lock.writeLock().unlock();
        }
    }

    //读取 (所有人都可以读)
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } finally {
            lock.readLock().unlock();
        }
    }
}

public class JUCTest2 {

    public static int vacantSeats = 50;

    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        //存写的线程
        for (int i = 0; i < 5; i++) {
            int temp=i;
            new Thread(()->{
                myCache.put(String.valueOf(temp), temp);
            }, String.valueOf(i)).start();
        }

        //读写的线程
        /*for (int i = 0; i < 5; i++) {
            int temp=i;
            new Thread(()->{
                myCache.get(String.valueOf(temp));
            },String.valueOf(i)).start();
        }*/
    }
}

