package solid;

import java.util.List;

public class AreaCalculator {

    public int sumOfAreas(List<Shape> shapes) {
        int sum = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Circle)
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            else if (shape instanceof Square)
                sum += Math.pow(((Square) shape).getLength(), 2);
        }

        return sum;
    }

    public String json(List<Shape> shapes) {
        return "{sum:%s}".formatted(sumOfAreas(shapes));
    }

}
