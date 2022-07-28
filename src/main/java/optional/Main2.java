package optional;

import java.util.Optional;

public class Main2 {

    public static void main(String[] args) {
        String name = (String) Optional.ofNullable(null).orElse(getString());
        System.out.println(name);

        name = (String) Optional.ofNullable(null).orElseGet(() -> getString());
        System.out.println(name);

        try {
            name = (String) Optional.ofNullable(null).orElseThrow(Exception::new);
            System.out.println(name);
        } catch (Exception e) {
            System.out.println("e.getCause()");
        }

    }

    public static String getString() {
        return "ahmet";
    }

}
