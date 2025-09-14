package bitwisemanuplation;

public class SingleNumber {

    public static void main(String[] args) {
        int arr[]  = {4,1,2,1,2};

        int result = 0;
        for(int i: arr) {
            result = result ^ i;
            System.out.print("result " + result +" ");
        }
        System.out.println(result);

    }
}
