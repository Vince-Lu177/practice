package Practice_0621;


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String x : arr) {
            Integer value = map.get(x);
            if(value == null){
                map.put(x,1);
            }else{
                map.remove(x);
            }
        }
        String a = null;
        String b = null;
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                a = entry.getKey();
            }
        }
        map.remove(a);
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                b = entry.getKey();
            }
        }
        System.out.println(Integer.parseInt(a) > Integer.parseInt(b) ? b + "" + a : a + "" + b);

    }

}


