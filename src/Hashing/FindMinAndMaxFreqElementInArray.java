package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindMinAndMaxFreqElementInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int arr[] = new int[s.nextInt()];

        for(int i =0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }

        findMinMaxFrq(arr);
    }
    private static void findMinMaxFrq(int arr[]) {
        int maxFre=0, maxValue=0, minFre=Integer.MAX_VALUE, minValue =0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int value:arr) {
           map.put(value, map.getOrDefault(value, 0)+1);
        }
        for(Map.Entry<Integer, Integer> value :map.entrySet()) {

            if(maxFre<value.getValue()) {
                maxFre = value.getValue();
                maxValue = value.getKey();

            }
            if (minFre>value.getValue()) {
                minFre = value.getValue();
                minValue = value.getKey();
            }

        }

        System.out.println(" Min Freq and Min Value " + minFre + " " +minValue);
        System.out.print(" Max Freq and Max Value "  + maxFre + " " +maxValue);
    }
}
