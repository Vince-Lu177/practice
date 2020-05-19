package Practice_0519;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
