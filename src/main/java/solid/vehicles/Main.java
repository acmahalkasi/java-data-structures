package solid.vehicles;

public class Main {

    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();
        bike.go();
        bike.stop();
        bike.fold();
        car.refuel();
    }

}
