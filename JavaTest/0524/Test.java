package Practice_0524;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal("小动物");
        Animal animal1 = animal.clone();
        System.out.println(animal == animal1);
    }
}
