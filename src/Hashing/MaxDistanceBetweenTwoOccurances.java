package Hashing;

import java.util.HashMap;

public class MaxDistanceBetweenTwoOccurances {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.print(maxDistance(arr));
    }
    // yaha samjh map ko uupdate nhi kr latest occuring se kyoki ultimatlely tu jo pahle aaya ussi ki distance dekhega .
    private static int maxDistance(int arr[]) {
        int maxDistance = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++) {
            if (map.containsKey(arr[i])) {
                int distance = i-map.get(arr[i]);
                maxDistance = Math.max(maxDistance, distance);
            }
            else{
                map.put(arr[i], i);
            }
        }
        return maxDistance;
    }
}
