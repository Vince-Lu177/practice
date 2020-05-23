package Practice_0523;

public class SignalTest {
    public static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    while(true){
                        synchronized (SignalTest.class){
                            if(SUM + 3 > 100){
                                SignalTest.class.wait();
                            }else{
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName() + "生产了面包,库存:" + SUM);
                                Thread.sleep(500);
                                SignalTest.class.notify();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"面包师傅[" + i + "]").start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    while(true){
                        synchronized (SignalTest.class){
                            if(SUM == 0){
                                SignalTest.class.wait();
                            }else{
                                SUM--;
                                System.out.println(Thread.currentThread().getName() + "消费了面包,库存:" + SUM);
                                Thread.sleep(500);
                                SignalTest.class.notify();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"消费者[" + i + "]").start();
        }
    }
}
