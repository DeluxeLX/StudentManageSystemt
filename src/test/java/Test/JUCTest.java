package Test;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static Test.JUCTest.vacantSeats;

/**
 * 加锁的自定义缓存
 */
class MyCacheLock{
    private volatile HashMap<String,Object> map = new HashMap<>();
    //读写锁,更加细腻度的控制
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //存写 (存写的时候只希望有一个线程进行)
    public void put(String key, Object value) {
        // 上一把写锁，排他锁
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在选课" + key + ":" + value);
            map.put(key, value);
            if (vacantSeats != 0) {
                vacantSeats = vacantSeats - 1;
                System.out.println(Thread.currentThread().getName() + "选课完毕；现在空闲座位为" + vacantSeats);
            } else {
                System.out.println(Thread.currentThread().getName() + "选课失败；现在空闲座位为" + vacantSeats);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class JUCTest {

    public static int vacantSeats = 3;

    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        // 选课的线程
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(()->{
                myCache.put(String.valueOf(temp), temp);
            }, String.valueOf(i)).start();
        }
    }
}
