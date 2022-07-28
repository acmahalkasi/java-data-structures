package try_with_resource;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in); MyCloasable close = new MyCloasable()) {
            while(scan.hasNext()) {
                System.err.println(scan.nextLine());
            }

            close.print();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
