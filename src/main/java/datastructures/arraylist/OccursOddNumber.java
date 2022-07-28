package datastructures.arraylist;

import java.util.HashMap;

//https://java2blog.com/find-number-occurring-odd-number-of-times-in-array/
        /**
         * You are given a array of integer. All numbers occur even number of times except one. 
         * You need to find the number which occurs odd number of time. You need to solve it with o(n) 
         *  time complexity and o(1) space complexity.
         */
class OccursOddNumber {

    public static void main(String[] args) {

        HashMap<Integer, Integer> countOfElements = new HashMap<>();
        int array[] = {20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        for (int i=0; i<array.length; i++) {
            if (countOfElements.get(array[i]) == null)
                countOfElements.put(array[i], 1);
            else
                countOfElements.put(array[i], countOfElements.get(array[i])+1);
        }

        int answer = countOfElements.keySet().stream()
            .filter(i -> countOfElements.get(i) %2 != 0).findAny().get();

        System.out.println(answer);

        //second and the best solution by xor operation
        answer = getOddTimesElement(array);
        System.out.println("Number which occurs odd number of times is : "+answer);



    }


    static int getOddTimesElement(int ar[])
    {
        int i;
        int result = 0;
        for (i = 0; i < ar.length; i++) {
            // XOR operation
            result = result ^ ar[i];
        }
        return result;
    }

}