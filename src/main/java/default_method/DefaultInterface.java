package default_method;

public interface DefaultInterface {

    default void printName(){
        System.out.println("default method");
    }

    void printMethod(String s);

}
