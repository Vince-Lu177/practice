package Practice_0629;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int sum = getSum(num);
            int squSum = getSum(num * num);
            System.out.println(sum + " " + squSum);
        }
    }
    private static int getSum(int num){
        if(num <= 9){
            return num;
        }
        return num%10 + getSum(num/10);
    }
}
