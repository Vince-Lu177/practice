package Practice_0705;

public class SynchronizedTest {
    public static void main(String[] args) {
        Data date = new Data();
        new Thread(()->{
            try {

                for (int i = 0;i<10;i++) {
                    date.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i = 0;i<10;i++) {
                    date.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {

                for (int i = 0;i<10;i++) {
                    date.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
        new Thread(()->{
            try {
                for (int i = 0;i<10;i++) {
                    date.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"D").start();
    }
}
     class Data{
        private int num = 0;
        public synchronized void increment() throws InterruptedException {
            while(num != 0){
                this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+" "+num);
            this.notifyAll();
        }
        public synchronized void decrement() throws InterruptedException {
            while(num == 0){
                this.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+" "+num);
            this.notifyAll();
        }
    }

