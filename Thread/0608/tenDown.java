package Practice_0608;

import java.text.SimpleDateFormat;
import java.util.Date;

class timeDown {

    public static void timedown(int i) throws InterruptedException {
        for (int j = i; j >=0 ; j--) {
            Thread.sleep(1000);
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        //timedown(10);
        //获取当前系统时间
        Date startTime = new Date(System.currentTimeMillis());
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //按格式化输出时间
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            //更新当前时间
            startTime = new Date(System.currentTimeMillis());
        }
    }
}
