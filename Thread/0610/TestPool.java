package Practice_0610;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.execute( new MyThreadPool());
        service.shutdown();

    }
}

class MyThreadPool implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}