package Practice_0703;

public class Main2 {
    public static void main(String[] args) {
        byte b = '3';
        String binaryString = Integer.toBinaryString(b);
        for (int i = 0; i < 8 - binaryString.length(); i++) {
            binaryString = "0" + binaryString;
        }
        System.out.println(binaryString);
    }
}
