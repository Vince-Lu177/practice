package Practice_0722;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int total = scanner.nextInt();
            String[] arr = new String[total];
            for (int i = 0; i < total; i++) {
                arr[i] = scanner.next();
            }
            String target = scanner.next();
            int num = scanner.nextInt();
            int count = 0;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if(isBother(arr[i],target)){
                    count++;
                    list.add(arr[i]);
                }
            }
            if(count>=num){
                System.out.println(count);
            }
            Collections.sort(list);
            System.out.println(list.get(num - 1));
        }
    }

    private static boolean isBother(String s1,String s2){
        if(s1.length()!=s2.length()||s1.equals(s2)){
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(!String.valueOf(arr1).equals(String.valueOf(arr2))){
            return false;
        }
        return true;
    }
}
