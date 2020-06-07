package Practice_0607;

public class TestThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我在认真看书" + i);
        }
    }

    public static void main(String[] args) {
        TestThread2 testThread2 = new TestThread2();
        Thread thread = new Thread(testThread2);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在认真写代码" + i);
        }
    }
}
