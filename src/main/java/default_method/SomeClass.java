package default_method;

public class SomeClass implements DefaultInterface{
    @Override
    public void printName() {
        DefaultInterface.super.printName();
        //System.out.println("overridden");
    }

    @Override
    public void printMethod(String s) {
        System.out.println(s);
    }
}
