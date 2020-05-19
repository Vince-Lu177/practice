package Practice_0519;

public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
          while(Thread.interrupted()) {
              System.out.println(Thread.currentThread().getName());
          }
              try {
                  while(!Thread.interrupted()) {
                      System.out.println(Thread.currentThread().getName());
                      Thread.sleep(222222222);}

              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}
