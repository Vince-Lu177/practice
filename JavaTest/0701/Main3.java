package Praztice_0701;

import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        try {
            String str = "java216651651621651156165";
            while(true){
                str+=new Random(999999999).nextInt()+new Random(999999999).nextInt();
            }
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
