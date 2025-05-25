package DP;

public class CalculateSum {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int index = 5;
        System.out.print(calculateSum(arr, index));
    }
    private static int calculateSum(int arr[], int index) {
        int dpArray[] = new int[arr.length];
        dpArray[0] = arr[0];
        for(int i =1;i<arr.length;i++){
            dpArray[i] = arr[i]+dpArray[i-1];
        }
        return dpArray[index];
    }
}
