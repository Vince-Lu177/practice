package Practice_0703;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] strings = new String[Integer.parseInt(s)];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = scanner.nextLine();
            }
            for (int bound = 0; bound < strings.length; bound++) {
                for(int cur = strings.length - 1;cur>bound;cur--){
                    if(strings[cur-1].length()>strings[cur].length()){
                        String tmp = strings[cur-1];
                        strings[cur-1] = strings[cur];
                        strings[cur] = tmp;
                    }
                }
            }
            for (int bound = 0; bound < strings.length; bound++) {
                for(int cur = strings.length - 1;cur>bound;cur--){
                    if(strings[cur-1].length()==strings[cur].length()&&strings[cur-1].compareTo(strings[cur])>0){
                        String tmp = strings[cur-1];
                        strings[cur-1] = strings[cur];
                        strings[cur] = tmp;
                    }
                }
            }
            /*for (int i = 0; i < strings.length - 1; i++) {
                if(strings[i].length() == strings[i+1].length()&&strings[i].compareTo(strings[i+1])>0){
                    String tmp = strings[i];
                    strings[i] = strings[i+1];
                    strings[i+1] = tmp;
                }
                if(strings[cur-1].length()==strings[cur].length()&&strings[cur-1].compareTo(strings[cur])>0){
                        String tmp = strings[cur-1];
                        strings[cur-1] = strings[cur];
                        strings[cur] = tmp;
                    }
            }*/

            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
            }
        }
    }
}
