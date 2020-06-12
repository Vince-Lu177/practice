package Practice_0612;
import java.util.Arrays;

public class Main {
    public static int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }



    public static String[] getGray(int n) {
        String[] res = new String[n + 1];
        res[0] = "0";
        for (int i = 1; i < n + 1; i++) {
            res[i] = String.valueOf(pow(i));
        }
        return res;
    }
    private static int pow(int n){
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;
        }
        return result - 1;
    }
    public static void main(String[] args) {
        int n = 3;
        String[] res = getGray(n);
        System.out.println(Arrays.toString(res));
    }
}

