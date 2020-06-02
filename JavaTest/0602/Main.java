package Practice_0602;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void get(){
            Scanner sc;
            sc = new Scanner(System.in);
            while(sc.hasNext()){
                int num = sc.nextInt();
                System.out.println(drink(num));
        }
    }
    public static int drink(int n) {
        int sum = 0;//喝的饮料数
        int org = n;
        int plus = 0;
        while (true) {
            sum += org / 3;
            plus = org / 3 + org % 3;
            if (plus >= 3) {
                org = plus;
            }
            if (plus == 2) {
                sum++;
                break;
            }
            if (plus == 0 || plus == 1) {
                break;
            }
        }
        return sum;
    }


}
