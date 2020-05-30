package Practice_0530;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class printerWriterTest {
    @Test
    public void t1(){
        try {
            int t = 1 / 0;
            System.out.println("1/0");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            System.out.println(pw.toString());
        }
        System.out.println("t1");
    }

    @Test
    public void t2(){
        File f1 = new File("\"C:\\Users\\LQQ2632469293\\Desktop\\javaCode\\Thread\"");
        File[] result = f1.listFiles();
        for (File f2: result) {
            System.out.println(f2.getName());
        }
    }
}
