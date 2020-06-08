package Practice_0608;


public class TestPriority {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);


        t1.setPriority(1);
        t1.start();
        t2.setPriority(5);
        t2.start();
        t3.setPriority(7);
        t3.start();
        t4.setPriority(10);
        t4.start();
        t5.setPriority(2);
        t5.start();
    }
}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
    }
}