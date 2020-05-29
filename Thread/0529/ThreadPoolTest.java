package Practice_0529;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolTest {
    private static ExecutorService FIXED_POOL = Executors.newFixedThreadPool(4);
    private static ScheduledExecutorService SCHEDULED_POOL = Executors.newScheduledThreadPool(4);

    public static void runFixedThreadPool(Runnable task){
        FIXED_POOL.execute(task);
    }

    public static void main(String[] args) {
//        runFixedThreadPool(()->{
//
//        });

        SCHEDULED_POOL.scheduleAtFixedRate(()->{
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(dateFormat.format(date));
        },1,1, TimeUnit.SECONDS);
    }
}
