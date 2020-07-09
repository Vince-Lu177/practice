package Practice_0707;

public class Main2 {
    public static int countWays(int n) {
        // write code here
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }if(n == 3){
            return 4;
        }
        int last1 = 1;
        int last2 = 2;
        int last3 = 4;
        int cur = 0;
        for (int i = 4; i <= n; i++) {
            cur = last1+last2+last3;
            last1 = last2;
            last2 =last3;
            last3 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(countWays(6));
    }
}
