package Practice_0705;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List list = Arrays.asList("1","2","3");
//        list.forEach(System.out::println);
//        Map<Integer,Integer> map = new HashMap();
//        map.put(1,1);
//        map.put(2,2);
//        map.put(3,3);
//        map.put(4,4);

        /**
         *解决方案
         * 1.使用Vector
         * 2.使用Collections.sychronizedList(new ArrayList)
         * 3.使用CopyOnWriteArrayList
         **/
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
