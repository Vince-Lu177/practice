package Practice_0717;

public class Main2 {
    public static void main(String[] args) {
        int[] arr2 = {-1,-2,12,3};
        int left = 0;
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]<0){
                left++;
            }else{
                break;
            }
        }
        System.out.println(left);
    }
    private static boolean isVaild(String s){
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
