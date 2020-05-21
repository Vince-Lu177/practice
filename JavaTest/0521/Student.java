package Practice_0520;

public class Student implements Comparable {
    private String name;
    private double Chinese_score;
    private double math_score;

    public Student(String name, double chinese_score, double math_score) {
        this.name = name;
        Chinese_score = chinese_score;
        this.math_score = math_score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Chinese_score=" + Chinese_score +
                ", math_score=" + math_score +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        if(this.Chinese_score > s.Chinese_score){
            return -1;
        }else if(this.Chinese_score < s.Chinese_score){
            return 1;
        }else{
            if(this.math_score > s.math_score){
                return -1;
            }else if(this.math_score > s.math_score){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
