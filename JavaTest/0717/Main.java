package Practice_0717;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] arr = s.split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < arr.length; i++) {
                if(isVaild(arr[i])){
                    if(arr[i].substring(0,1).equals("A")){
                        x-=Integer.parseInt(arr[i].substring(1));
                    }if(arr[i].substring(0,1).equals("S")){
                        y-=Integer.parseInt(arr[i].substring(1));
                    }if(arr[i].substring(0,1).equals("W")){
                        y+=Integer.parseInt(arr[i].substring(1));
                    }if(arr[i].substring(0,1).equals("D")){
                        x+=Integer.parseInt(arr[i].substring(1));
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
    private static boolean isVaild(String s){
        if(s.isEmpty()){
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c<'0'||c>'9'){
                return false;
            }
        }
        String first = s.substring(0,1);
        return first.equals("A")||first.equals("S")||first.equals("W")||first.equals("D");
    }
}
