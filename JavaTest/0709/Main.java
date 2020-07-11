package Practice_0709;

public class Main {
    public static void main(String[] args) {
        System.out.print(300);
        int res = 0;
        for (int i = 0; i <= 29; i++) {
            res += (int)Math.pow(2,i);
        }
        System.out.print(" "+res);
    }
}
