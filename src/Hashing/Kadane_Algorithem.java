package Hashing;

public class Kadane_Algorithem {
    public static void main(String[] args) {
        int arr[] = {4, 3, -2, 6, -14, 7,-1, 4, 5,7,-10, 2, 9, -10, -5 ,-9,6,1};
        kadaneAlgorithm(arr);
    }
    // kadane kahati ki tum peeche se sum leke aao mae current node pr decide krunga ki mujeh usme add hone ka h ya nhi warn m
    // apni new chain start kru
    private static void kadaneAlgorithm(int arr[]) {
        int currentSum = arr[0];
        int bestSum = arr[0];

        for(int i =1;i<arr.length;i++) {
            if (currentSum >=0) {
                currentSum = currentSum+arr[i];
            }
            else{
                currentSum = arr[i];
            }
            if (currentSum>bestSum) {
                bestSum = currentSum;
            }
        }
        System.out.print(bestSum);
    }
}
