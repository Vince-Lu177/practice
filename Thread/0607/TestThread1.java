package Practice_0607;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我在认真看书" + i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在认真写代码" + i);
        }
    }
}
