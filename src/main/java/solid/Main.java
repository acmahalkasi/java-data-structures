package solid;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList.stream()
                .map((var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));

        AreaCalculator areaCalculator = new AreaCalculator();
        Shape circle = new Circle(10);
        Shape square = new Square(10);
        List<Shape> shapes = List.of(circle, square);
        int sum = areaCalculator.sumOfAreas(shapes);
        System.out.println(sum);
    }

}
