package solid.vehicles;

public class Car implements MotorizedVehicle{
    @Override
    public void refuel() {
        System.out.println("I will be refueled soon");
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
