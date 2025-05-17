package Hashing;

import java.util.*;

public class MakeAllPilesInEqualHieght {
    public static void main(String[] args) {
        int arr[] = {4,5,5,2,4};
        countStepToMakePilesInSameHeight(arr);
        System.out.println("Rahul yadav: " +countStepToMakePilesInSameHeight(arr));
    }
    /**
     * 5, 2,1
     * bruet force approch  sabko same hight mae lana h toh loop chalate jao jab tk ye same hieght nhi  ho jate
     * to ek largest and second largest lo aur replace krte raho value ko
     *
     */

    private static void makePilesInSameHeight(int[] arr) {
        boolean temp = true;
        while(temp) {
            for(int i =0;i<arr.length;i++) {

            }
        }
    }

    /**
     *bhai hash map bana usme sbki frequency daal ske baad last se second last ko replace kr jaise 5=2, 4=2, 2=1 toh fiorst mae
     * 5 =0, 4 =4
     */
    private static int countStepToMakePilesInSameHeight(int[] arr) {
        Map<Integer, Integer> map= new TreeMap<>(Collections.reverseOrder());

        for(int value:arr) {
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        // Traverse the list g backwards and update frequencies and steps
        List<Map.Entry<Integer, Integer>> g = new ArrayList<>(map.entrySet());
        for (int i =0;i<g.size(); i++){
            System.out.println(g.get(i));
        }
        int count =0;
        for (int i = 0; i < map.size()-1; i++) {
            System.out.println(g.get(i));
            // Update frequency of previous element
            g.get(i + 1).setValue(g.get(i + 1).getValue() + g.get(i).getValue());

            // Increment the step by the frequency of the current element
            count += g.get(i).getValue();

            // Set the frequency of the current element to 0 (not necessary since we are updating the previous element)
            g.get(i).setValue(0);
        }
        return count;
    }
}
