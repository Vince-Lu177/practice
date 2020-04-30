import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = getSteps(num);
        System.out.println(res);
    }

    private static int getSteps(int num) {
        for (int i = 0; i < num; i++) {
            int n1 = Fib(i);
            int n2 = Fib(i - 1);
            int n3 = Fib(i - 2);
            if(num == n1 || num == n2 || num == n3){
                return 0;
            }else if(num > n2 && num <n1){
                return Math.min((num - n2), (n1 - num));
            }else if(num > n3 && num <n1){
                return Math.min((num - n3), (n1 - num));
            }
        }
        return -1;
    }

    private static Integer Fib(int num){
        if(num == 0){
            return 0;
        }
        int last1 = 1;
        int last2 = 1;
        int cur = 0;
        for (int i = 3; i < num; i++) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }


}
