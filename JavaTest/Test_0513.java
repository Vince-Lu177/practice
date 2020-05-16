package Practice_0513;

import java.util.Date;

public class Test_0513 {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date.getTime());
        Animal cat1 = new Cat(" 小黑 ");//直接赋值
        cat1.eat(" 猫粮 ");
        Cat cat2 = new Cat(" 小白 ");
        feed(cat2);//方法传参
    }

    public static void feed(Animal animal){
        animal.eat(" 谷子 ");
    }
    public static Animal findMyAnimal(){
        Cat cat = new Cat(" 大黄 ");
        return cat;//方法返回
    }
}
