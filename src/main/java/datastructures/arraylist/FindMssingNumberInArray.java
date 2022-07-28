package datastructures.arraylist;

import java.util.Arrays;

import javax.sound.midi.Soundbank;

/**
     * https://java2blog.com/java-program-to-find-missing-number-in-array/
     *
     * @param args
     */
public class FindMssingNumberInArray {

    
    public static void main(String[] args) {
        int[] arr1={7,5,6,1,4,2};
        int currentNum = 1;
        for (int i=0; i < arr1.length; i++) {
            if(currentNum == arr1[i]) { 
                currentNum++;
                i = 0;
            }
        }

        System.out.println(currentNum + " is not in the list -> solution1");

        int n = arr1.length + 1;
        int sumOfElements = (n * (n+1)) / 2;
        int sum = 0;
        for (int i=0; i < arr1.length; i++) {
            sum += arr1[i];
        }

        int missingNum = sumOfElements - sum;
        System.out.println(missingNum + " is not in the list -> solution2");

        



    }





}
