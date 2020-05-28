package Practice_0527;

public class BlockingQueue<T> {
    private Object[] table;
    private int putIndex;
    private int takeIndex;
    private int size;

    public BlockingQueue(int capacity) {
        table = new Object[capacity];
    }

    public synchronized int size(){
        return size;
    }

    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length) {
            wait();
        }
        table[putIndex] = element;
        putIndex = (putIndex + 1) % table.length;
        size++;
        Thread.sleep(500);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object element = table[takeIndex];
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        Thread.sleep(500);
        notifyAll();
        return (T) element;
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while(true){
                        synchronized (blockingQueue) {
                            blockingQueue.take();
                            System.out.println("取面包 - 1" + blockingQueue.size);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    while(true){
                        synchronized (blockingQueue) {
                            blockingQueue.put(1);
                            System.out.println("存面包 + 1" + blockingQueue.size);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
