package Practice_0608;


public class TestStop implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        int i =0;
        while(flag){
            System.out.println("线程运行中" + i++);
        }
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 900){
                testStop.stop();
                System.out.println("该线程停止了");
            }
        }
    }

    private void stop(){
        this.flag = false;
    }
}
