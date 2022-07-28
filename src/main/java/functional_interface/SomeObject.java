package functional_interface;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

public class SomeObject implements Printable{

    String name = "ahmet";
    int age = 29;
    int deneme = 6;
    String name2 = "ahmet2";

    public SomeObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void print(String s, int a) {
        System.out.println(String.format("print from some object with params : %s %d", s ,a));
    }

    public void print(Printable printable) {
        printable.print(name, age);
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        SomeObject so = (SomeObject) o;
        return so.age == age && Objects.equals(name, so.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
