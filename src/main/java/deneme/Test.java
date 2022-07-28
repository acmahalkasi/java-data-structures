package deneme;

public class Test {

    void print(int i) {
        System.out.println("int:"+i);
    }

    void print(long i) {
        System.out.println("long:"+i);
    }

    void print(Integer i) {
        System.out.println("Integer:"+i);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.print(10l);
    }
}
