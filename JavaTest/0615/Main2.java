package Practice_0615;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 0) {
            System.out.println(0);
            return;
        }
        int step = num / 2;
        int mid = num * num;
        if (num % 2 != 0) {
            int beg = mid - step * 2;
            int end = mid + step * 2;
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = beg; i <= end; i += 2) {
                if (i == end) {
                    stringBuilder.append(i);
                } else {
                    stringBuilder.append(i + "+");
                }
            }
            System.out.println(stringBuilder.toString());
        }
        if(num % 2 == 0){
            int beg = mid - step * 2 + 1;
            int end = mid + step * 2 - 1;
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = beg; i <= end; i += 2) {
                if (i == end) {
                    stringBuilder.append(i);
                } else {
                    stringBuilder.append(i + "+");
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
