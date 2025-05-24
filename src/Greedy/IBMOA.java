package Greedy;

public class IBMOA {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4, 5};
        int target= 3;
        int targetArray[] = {4, 3,1};
       int ans =   findMinimunNumberOfOperation(arr, target);
//       System.out.print(ans);

       findMinimumNumberOfOperationToMSkeEqual(arr,targetArray);
    }

    /**
     * Understanding :- Given array of size N  and target -> Find the minimum number of operation needed to make all
     * element of array equal to target.
     */

    /**
     * Example :- [1,2,3,4, 5] target - 3
     */


    // bruet force approch
    private static int findMinimunNumberOfOperation(int arr[], int target) {

        int operation = 0;


        for (int value: arr) {
            int difference = target- value;

            operation = operation+Math.abs(difference);

        }
        return operation;
    }

    // use this target*N-sum of array
    private static void findMinimumNumberOfOperationToMSkeEqual(int arr[], int target[]) {


        int sum = 0;


        for (int value: arr) {
            sum = sum+value;
        }

        for (int value:target) {
            System.out.println(Math.abs(value*arr.length-sum));
        }

    }


}
