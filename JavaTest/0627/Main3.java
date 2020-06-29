package Practice_0627;

import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        int N = parseInt(s1.substring(0,1));
        int M = parseInt(s1.substring(2,3));
        String s2 = scanner.nextLine();
        String[] strings = s2.split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(strings[i]);
        }

        String[] arr2 = new  String[M];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scanner.nextLine();
        }
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i].substring(0,1).equals("Q") ){
                print(arr, parseInt(arr2[i].substring(2, 3))-1,
                        parseInt(arr2[i].substring(4,5)));
            }
            if(arr2[i].substring(0,1) .equals("U") ){
                arr = updata(arr, parseInt(arr2[i].substring(2, 3))-1, parseInt(arr2[i].substring(4,5)));
            }
        }
   }
    private static void print(int[] arr,int beg,int end){
        int max = 0;
        for(int i = beg;i<end;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    private static int[] updata(int[] arr,int index,int num){
        int[] res = arr.clone();
        res[index] = num;
        return res;
    }
}
