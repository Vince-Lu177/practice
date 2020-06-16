package Practice_0615;


import java.util.Scanner;
//2 2 0 0 0 3 0 0 1 0
//0 2 0 0 0 3 0 0 1 0
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < Integer.parseInt(strings[i]); j++) {
                stringBuilder.append(i);
            }
        }
        String s2 = stringBuilder.toString();
        String[] arr = s2.split("");
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.parseInt(arr[i]);
        }
        if(res[0] != 0){
            System.out.println(s2);
            return;
        }else{
            for (int i = 0; i < arr.length; i++) {
                if(res[i] != 0){
                   int tmp = res[0];
                   res[0] = res[i];
                   res[i] = tmp;
                   break;
                }
            }
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < res.length; i++) {
            result.append(res[i]);
        }
        System.out.println(result);
    }
}
