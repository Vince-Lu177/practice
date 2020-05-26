package Practice_0526;

public class SequencePrint {

    public static void print1(){
        Thread t1 = new Thread(new print("A",null));
        Thread t2 = new Thread(new print("B",t1));
        Thread t3 = new Thread(new print("c",t2));
        t1.start();
        t2.start();
        t3.start();
    }
    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            System.out.printf("A");
//        });
//        t1.start();
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Thread t2 = new Thread(()->{
//            System.out.printf("B");
//        });
//        t2.start();
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Thread t3 = new Thread(()->{
//            System.out.printf("C");
//        });
//        t3.start();;
//        try {
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        print1();
    }

    private static class print implements Runnable {

        private final String content;
        private Thread t;

        public print(String content, Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {

                try {
                    if(t != null) {
                        t.join();
                    }
                    System.out.println(content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }



