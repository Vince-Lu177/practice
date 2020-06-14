package Practice_0614;

import java.util.Arrays;

import static java.lang.Long.*;

public class Main2 {

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
        long a = Long.parseLong(addend);
        long b = Long.parseLong(augend);
        long c = a + b;
        return String.valueOf(c);
    }


}

