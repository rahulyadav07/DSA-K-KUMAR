package Hashing;

import java.util.HashMap;

public class FrequencyOfElementInArray {
    public static void main(String[] args) {
        int[] arr = {0, 5,5,5,4};
        int x = 2;
        System.out.println(countFrequencyOfArray(arr, x));
    }
    private static int countFrequencyOfArray(int [] arr , int x) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int value: arr) {
            map.put(value, map.getOrDefault(value, 1)+1);
        }
       return map.getOrDefault(x, 0);
    }
}
