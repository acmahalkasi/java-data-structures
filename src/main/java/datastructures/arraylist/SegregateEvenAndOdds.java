package datastructures.arraylist;

import java.util.Arrays;

//https://java2blog.com/separate-odd-and-even-numbers-in-array/
class SegregateEvenAndOdds {
    public static void main(String[] args) {
     
        int[] arr = {12, 17, 70, 15, 22, 65, 21, 90};
        int[] segregated = new int[arr.length];

        int segregatedEvenIndex = 0;
        int segregatedOddIndex = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                segregated[segregatedEvenIndex] = arr[i];
                segregatedEvenIndex++;
            } else {
                segregated[segregatedOddIndex] = arr[i];
                segregatedOddIndex--;
            }
        }

        Arrays.stream(segregated).forEach(i -> System.out.printf("%d ", i));;


    }
}