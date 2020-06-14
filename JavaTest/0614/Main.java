package Practice_0614;

import java.util.Arrays;

public class Main {
    public static String AddLongInteger(String addend,String augend){
        if(addend == null && augend == null){
            return null;
        }
        if(addend == null){
            return augend;
        }
        if(augend == null){
            return addend;
        }
        if(addend.length() <= augend.length()){
            String tmp = addend;
            addend = augend;
            augend = tmp;
        }
        int m = augend.length() - addend.length();
        byte[] arr = new byte[m];
        for (int i = 0; i < m; i++) {
            arr[i] = 0;
        }
        String s = arr.toString();
        augend = s + augend;
        byte[] a1 = addend.getBytes();
        byte[] a2 = augend.getBytes();
        byte[] res = new byte[addend.length()];
//        if(a1[0] + a2[0] >=10){
//             res = new byte[addend.length() + 1];
//            res[0] = (byte) (a1[0] + a2[0] - 10);
//        }else{
//             res = new byte[addend.length()];
//        }
        for(int i = a1.length - 1; i > 0;i--){
            for(int j = a2.length - 1;j > 0;j--){
                if(a2[j] + a1[i] >= 10){
                    a1[i - 1]++;
                    res[i] = (byte) (a2[j] + a1[i] - 10);
                    break;
                }else{
                    res[i] = (byte) (a2[j] + a1[i]);
                    break;
                }
            }
        }
        return Arrays.toString(res);
    }

    public static void main(String[] args) {
        System.out.println(AddLongInteger("111111111111111111","222222222222222222"));
    }
}
