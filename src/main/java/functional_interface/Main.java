package functional_interface;

public class Main {

    public static void main(String[] args) {

        Printable lambdaPrintable = (s, a) -> System.out.println("name %s age %d".formatted(s, a));
        lambdaPrintable.print("okkes", 1);

        SomeObject so = new SomeObject("okkes", 1);
        SomeObject so2 = new SomeObject("okkes", 1);

        so.print("okkes", 4);

        System.out.printf("==? %b%n", so == so2);
        System.out.printf("equals? %b%n",so.equals(so2));
        System.out.printf("hashCode()? %b", so.hashCode() == so2.hashCode());



    }

    private static void print(Printable printable) {
        printable.print("okkes", 1);
    }

}
