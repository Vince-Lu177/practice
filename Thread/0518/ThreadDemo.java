package Practice_0518;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
//        new Thread (new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(66666666666L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"first blood").start();
//        Thread.sleep(66666666666L);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("first blood");
            }
        }).start();
        Thread.sleep(666L);
        System.out.println("main");
    }
}
