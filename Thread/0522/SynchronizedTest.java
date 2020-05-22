package Practice_0522;

public class SynchronizedTest {
    public static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    increment(j);
                }
            }).start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(SUM);
    }

    private static synchronized void increment(int j) {
        SUM++;
    }
}
