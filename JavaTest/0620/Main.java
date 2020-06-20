package Practice_0620;

public class Main {
    public static void main(String[] args) {
        int richman = 10;
        System.out.println(richman);
        int stranger = 0;
        for (int i = 0; i < 30; i++) {
            stranger += Math.pow(2,i);
        }
        System.out.println((int)stranger);
    }
}
