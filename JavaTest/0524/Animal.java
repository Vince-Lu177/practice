package Practice_0524;

public class Animal implements Cloneable{
    protected String animal;

    public Animal(String animal) {
        this.animal = animal;
    }

    @Override
    protected Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }
}
