interface Trainable {
    void performTrick();
}

abstract class Pet {
    protected String name;
    protected int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public void displayInfo() {
        System.out.println("Pet Name: " + name);
        System.out.println("Age: " + age);
        System.out.print(name + " says: ");
        makeSound();
        System.out.println();
    }
}

class Dog extends Pet implements Trainable {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void performTrick() {
        System.out.println("Training " + name + ": Sits and shakes");
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

class Bird extends Pet implements Trainable {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void performTrick() {
        System.out.println("Training " + name + ": Flies in circles and lands on perch");
    }
}
