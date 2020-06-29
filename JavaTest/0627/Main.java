package Practice_0627;


import java.util.Scanner;
//3 50
//50 105 200
//5 20
//30 20 15 40 100
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sv;
        while(scanner.hasNext()){
            synchronized (Main3.class) {
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();

                String[] s = s1.split(" ");
                sv = Integer.parseInt(s[1]);
                String[] strings = s2.split(" ");
                int[] arr = new int[strings.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(strings[i]);
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] <= sv) {
                        sv += arr[i];
                    } else {
                        sv += getMax(arr[i], sv);
                    }
                }
            }
                System.out.println(sv);
            }

    }
    private static int getMax(int a,int b){
        int c = Math.min(a,b);
        int i = c;
        for(;i>0;i--){
            if(a%i==0&&b%i==0){
              break;
            }
        }
        return i;
    }
}
