package Practice_0719;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String s3 = scanner.nextLine();

            if(Integer.parseInt(s2)>12||Integer.parseInt(s3)>31
                    ||Integer.parseInt(s2)<=0||Integer.parseInt(s3)<=0){
                System.out.println(-1);
                return;
            }
            Map<Integer,Integer> map = new HashMap<>();
            map.put(1,31);
            map.put(2,28);
            map.put(3,31);
            map.put(4,30);
            map.put(5,31);
            map.put(6,30);
            map.put(7,31);
            map.put(8,31);
            map.put(9,30);
            map.put(10,31);
            map.put(11,30);
            map.put(12,31);
            int res = 0;
            for (int i = 1; i < Integer.parseInt(s2); i++) {
                int days = map.get(i);
                if(days<Integer.parseInt(s3)){
                    System.out.println(-1);
                    return;
                }
                res+=days;
            }
            res+=Integer.parseInt(s3);

            int year = Integer.parseInt(s1);
            if(year%400==0||(year%4==0&&year%100!=0)&&Integer.parseInt(s2)>2){
                res++;
            }
            System.out.println(res);
        }
    }


