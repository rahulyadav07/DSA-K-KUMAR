package Hashing;

public class SumOfRange {
    /**
     *
     * solving by using prefix sum
     */
    public static void main(String[] args) {
        int[] arr = {3,2,3,2,32,3,2};
        // creating prefix array

       System.out.print(sumOfRange(
               arr, 2,4
       ));

    }
    private static int sumOfRange(int[] arr, int left, int right) {
        for(int i =1;i<arr.length;i++) {
            arr[i] = arr[i-1]+arr[i];
        }
        return arr[right]-arr[left-1];
    }
}
