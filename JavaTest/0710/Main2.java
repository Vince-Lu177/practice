package Practice_0710;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < 26; i++) {
            int count = 0;
            char c = (char) ('A'+i);
            for (int j = 0; j < s.length(); j++) {
                char toCount = s.charAt(j);
                if((c + "").equals(toCount + "")){
                    count++;
                }
            }
            System.out.println(c+":"+count);
        }
    }
}
