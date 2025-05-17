package Hashing;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        // take loop
        System.out.print(twoSum(arr, 9));
    }
    public  static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0;i<arr.length;i++) {
            int remaingValue = target-arr[i];
            if(map.containsKey(remaingValue)) {
                return new int[]{map.get(remaingValue), i};
            }
            else{
                map.put(arr[i], i);
            }
        }
        return new int[0];
    }
}
