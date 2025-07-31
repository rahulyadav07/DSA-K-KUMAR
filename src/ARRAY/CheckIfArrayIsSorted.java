package ARRAY;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int arr[] = {4,5,1,2,3};

        int count = 0;
        int length = arr.length;
        for(int i =0;i<length;i++) {

            System.out.print(  (i + 1) % length);
            if(arr[i]>arr[(i+1)%length]) {
                count++;
            }
        }
        System.out.print(count<=1);
    }
}
