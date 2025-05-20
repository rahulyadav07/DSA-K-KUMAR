package BinarySearch;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6 , 6, 7, 7, 9};
        int target = 6;
        System.out.println(upperBound(arr, target));
    }
    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1; // move right to find strictly greater element
            } else {
                right = mid; // keep looking in the left half
            }
        }

        return left; // 'left' is the first index with value > target
    }
}
