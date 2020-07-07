package Practice_0706;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(()->{
                myReadWriteLock.put(tmp+"",tmp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(()->{
                myReadWriteLock.get(tmp+"");
            },String.valueOf(i)).start();
        }
    }

}
class MyReadWriteLock{
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<String,String> map = new HashMap<>();
    public void put(String key,String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入成功");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            System.out.println(Thread.currentThread().getName() + "读取成功");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
