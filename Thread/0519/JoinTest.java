package Practice_0519;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("Thread Baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join(5000);
        System.out.println("main");
    }
}
