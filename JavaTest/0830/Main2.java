import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = Integer.parseInt(s.substring(0,1));
        String[] strings = new String[i-1];
        for (int j = 0; j < i-1; j++) {
            strings[j] = scanner.nextLine();
        }
        String n = strings[0];
        int[] pos = new int[i*2];
        int left = Integer.parseInt(n.substring(0,1));
        int right = Integer.parseInt(n.substring(2,3));
        pos[i] = left;
        pos[i+1] = right;
        for (int k = 1; k < strings.length; k++) {
            String e = strings[k];
            int l = Integer.parseInt(e.substring(0,1));
            int r = Integer.parseInt(e.substring(2,3));
            for (int m = 0; m < pos.length; m++) {
                if(l == pos[m] && pos[m+1]==0){
                    pos[m+1] = r;
                    break;
                }if(l == pos[m] && pos[m-1]==0){
                    pos[m-1] = r;
                    break;
                }if(r == pos[m] && pos[m+1]==0){
                    pos[m+1] = l;
                    break;
                }if(r == pos[m] && pos[m-1]==0){
                    pos[m-1] = l;
                    break;
                }
            }
        }

        int l2 = Integer.parseInt(s.substring(2,3));
        int l3 = Integer.parseInt(s.substring(4,5));

        int z = 0;
        for (int o = 0; o < pos.length; o++) {
            if(pos[o]!=0){
                z = o;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for(int p = z;p<z+i;p++){
            stringBuilder.append(pos[p]);
        }
        String s1 = stringBuilder.toString();
        int x = s1.indexOf(l2+"");//小美
        int y = s1.indexOf(l3+"");//小团

        if(x<y){
            System.out.println(i-x);
        }
        if(x>y){
            System.out.println(x);
        }
    }
}
