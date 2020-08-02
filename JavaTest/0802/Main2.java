package Practice_0802;


import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if(isBound(c1,c2)){
                str = str.substring(0,i + 1) + " " +str.substring(i + 1);
            }
        }
        String[] arr = str.split(" ");
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].charAt(0)<='9' && arr[i].charAt(0)>='0' && arr[i].length() > max){
                max = arr[i].length();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].charAt(0)<='9' && arr[i].charAt(0)>='0' && arr[i].length() == max){
                System.out.println(arr[i]);
            }
        }

    }

    public static boolean isBound (char c1, char c2){
        if(c1 <= 'z' && c1 >= 'a' && c2 <= '9' && c2 >= '0'){
            return true;
        }
        if(c2 <= 'z' && c2 >= 'a' && c1 <= '9' && c1 >= '0'){
            return true;
        }
        return false;
    }
}
