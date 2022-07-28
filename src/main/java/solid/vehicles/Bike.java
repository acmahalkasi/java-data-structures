package solid.vehicles;

public class Bike implements NonmotorizedVehicle {
    @Override
    public void fold() {
        System.out.println("I will be folded soon");
    }

    @Override
    public void go() {
        System.out.println("I am being rode");
    }

    @Override
    public void stop() {
        System.out.println("I am stopped!");
    }
}
