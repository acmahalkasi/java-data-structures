package datastructures.heap;

import java.util.ArrayList;
import java.util.Arrays;

import static com.google.common.math.DoubleMath.log2;


/**
 * Min-Heap data structure in Java
 */
public class HeapDataStructure {

    static ArrayList<Integer> integers = new ArrayList<>();

    void heapify(int i) {
        int smallest = i;
        int size = integers.size();

        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < size && integers.get(leftChild) < integers.get(smallest))
            smallest = leftChild;
        if (leftChild < size && integers.get(rightChild) < integers.get(smallest))
            smallest = rightChild;

        if (smallest != i) {
            int temp = integers.get(i);
            integers.set(i, integers.get(smallest));
            integers.set(smallest, temp);

            heapify(i);
        }

    }

    void insert(int data) {
        int size = integers.size();
        integers.add(data);
        while(integers.get(size) < integers.get(size / 2)) {
            swap(size, size/2);
            size = size / 2;
        }
    }

    private void swap(int i, int j) {
        int tmp = integers.get(i);
        integers.set(i, integers.get(j));
        integers.set(j, tmp);
    }

    void printArray() {
        int height = log2(integers.size()) + 1;

        for (int i = 1, len = integers.size(); i < len; i++) {
            int x = integers.get(i);
            int level = log2(i) + 1;
            int spaces = (height - level + 1) * 2;

            System.out.print(stringOfSize(spaces, ' '));
            System.out.print(x);

            if((int)Math.pow(2, level) - 1 == i) System.out.println(); System.out.flush();
        }

    }

    private String stringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }

    private int log2(int x) {
        return (int)(Math.log(x) / Math.log(2)); // = log(x) with base 10 / log(2) with base 10
    }

    public static void main(String[] args) {

        int size = integers.size();

        HeapDataStructure h = new HeapDataStructure();
        h.insert(3);
        h.insert(4);
        h.insert(9);
        h.insert(5);
        h.insert(2);
        h.insert(1);
        h.insert(0);
        h.insert(0);
        h.insert(0);
        h.insert(0);
        h.insert(0);
        h.insert(0);
        h.insert(0);
        h.insert(100000000);
        h.printArray();
    }

}
