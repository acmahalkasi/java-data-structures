package try_with_resource;

public class MyCloasable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("this will be closed soon.");
    }

    public void print() {
        System.out.println("printing");
    }
}
