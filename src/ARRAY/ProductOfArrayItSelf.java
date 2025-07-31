package ARRAY;

public class ProductOfArrayItSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
    public static int[] productExceptSelf(int[] nums) {
        int arr[] = new int[nums.length];
        int right = 1, left =1;

        for(int i =0 ;i<nums.length;i++) {
            arr[i] = left;
            left  = left * nums[i];
        }

        print(arr);
        for(int i =arr.length-1;i>=0;i--) {
            arr[i] = right*arr[i];
            right = right*nums[i];

        }
        print(arr);
        return arr;
    }
    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+ " ");
        }
    }
}
