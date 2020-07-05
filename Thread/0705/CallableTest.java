package Practice_0705;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        Integer i = (Integer) futureTask.get();
        System.out.println(i);
    }
}
class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}

