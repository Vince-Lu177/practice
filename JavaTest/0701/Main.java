package Praztice_0701;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (test(num)) {
                System.out.println("YES!");
            }
            if(!test(num)){
                System.out.println("NO!");
            }
        }
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str;
//            while ((str = br.readLine()) != null) {
//                int num = Integer.parseInt(str);
//                if (test(num)) {
//                    System.out.println("Yes!");
//                }
//                if (!test(num)) {
//                    System.out.println("No!");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
   }

    private static boolean test(int i) {
        int squ = i * i;
        String s = String.valueOf(squ);
        String s1 = String.valueOf(i);
        String s2 = s.substring(s.length() - s1.length());
        return s1.equals(s2);
    }
}
