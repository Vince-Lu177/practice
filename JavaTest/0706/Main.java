package Practice_0706;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static int countNumberOf2s(int n) {
        // write code here
        int len = String.valueOf(n).length();//数字位数
        int maxNum = (int) Math.pow(10, len - 1);//最高量级

        int max = n / maxNum;//最高位数值
        if (n<=1) {
            return 0;
        }
        if(n<11&&n>=2){
            return 1;
        }
        if (max >= 2) {
            int res1 = maxNum + (max - 1) * (maxNum / 10 + 9 * countNumberOf2s(maxNum / 10));
            int res2 = countNumberOf2s(n % maxNum);
            return res1+res2;
        }

        int res1 = maxNum / 10 + 9 * countNumberOf2s(maxNum / 10);
        int res2 = countNumberOf2s(n % maxNum);
        return res1 + res2;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(2251));
    }
}
