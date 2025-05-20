package BinarySearch;

import java.util.HashMap;

public class FindTarget {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        findTarget(nums, target);
    }
    private static void findTarget(int arr[], int tareget) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++) {
            int remainingValue = tareget- arr[i];

            if(map.containsKey(remainingValue)) {
                System.out.print("FirstValue " + remainingValue + " Second " + arr[i]);
                return;
            }
            else{
                map.put(arr[i], 1);
            }
        }
    }
}
