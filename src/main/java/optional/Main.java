package optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        optional = Optional.of("ahmet");
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        //optional = Optional.of(null);
        //System.out.println(optional.isPresent());
        //System.out.println(optional.isEmpty());

        optional = Optional.ofNullable(null);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        optional = Optional.ofNullable(null);
        String name = optional.orElse("ahmet");
        System.out.println(name);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        optional = Optional.ofNullable(null);
        name = optional.orElseGet(() -> "ahmet");
        System.out.println(name);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());



    }

}
