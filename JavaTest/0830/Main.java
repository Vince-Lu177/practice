import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String len = scanner.nextLine();
        String str = scanner.nextLine();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'M'){
                start = str.substring(i).indexOf("T");
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        String newStr = stringBuilder.reverse().toString();
        int end = 0;
        for (int i = 0; i < newStr.length(); i++) {
            char c = newStr.charAt(i);
            if(c == 'T'){
                end = newStr.substring(i).indexOf("M");
                break;
            }
        }
        if(start+1>str.length()-end-1){
            System.out.println("");
            return;
        }
        System.out.println(str.substring(start+1,(str.length()-end-1)));
    }
}
