package Practice_0705;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        Date3 date3 = new Date3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date3.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date3.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date3.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}
class Date3{
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private int num = 1;
    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (num!=1){
                condition1.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"->AAA");
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }
    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while(num!=2){
                condition2.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"->BBB");
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }
    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while(num!=3){
                condition3.await();
            }
            num = 1;
            System.out.println(Thread.currentThread().getName()+"->CCC");
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
