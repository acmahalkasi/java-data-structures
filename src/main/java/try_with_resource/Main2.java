package try_with_resource;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MyCloasable cloasable = new MyCloasable();

        try (scanner; cloasable) {
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());
            cloasable.print();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
