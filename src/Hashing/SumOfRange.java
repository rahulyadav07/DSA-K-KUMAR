package Hashing;

public class SumOfRange {
    /**
     *
     * solving by using prefix sum
     */
    public static void main(String[] args) {
        int[] arr = {1,4,1};
        // creating prefix array

       System.out.print(sumOfRange(
               arr, 1,1
       ));

    }
    // pahle prefix sum nikal liya uuske baad jo left index ki value m jo sum pda tha usse right usse ek peech se usse minus kr diya
    private static int sumOfRange(int[] arr, int left, int right) {
        for(int i =1;i<arr.length;i++) {
            arr[i] = arr[i-1]+arr[i];
        }
        return arr[right]-arr[left-1];
    }
}
