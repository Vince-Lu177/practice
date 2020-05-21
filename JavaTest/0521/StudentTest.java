package Practice_0520;

import java.util.Arrays;

public class StudentTest {
    public static void main(String[] args) {
        Student[] student = {
                new Student("小红",85,88),
                new Student("小花",89,95),
                new Student("小明",94,81),
                new Student("小慧",95,96),
                new Student("小杰",94,88)
        };
        Arrays.sort(student);
//        System.out.println(Arrays.toString(student));
        //sort(student);
        System.out.println(Arrays.toString(student));
    }

    public static void sort(Comparable[] array){
        for (int bound = 0; bound < array.length; bound++) {
            for(int cur = array.length - 1;cur > bound;cur--){
                if(array[cur - 1].compareTo(array[cur]) > 0){
                    Comparable tmp = array[cur - 1];
                    array[cur - 1] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }
}
