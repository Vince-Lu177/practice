package Practice_0520;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("小猫");
        walk(cat);
        Duck duck = new Duck("鸭子");
        walk(duck);
    }

    public static void walk(IRunning running){
        running.run();
    }
}
