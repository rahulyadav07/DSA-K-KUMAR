package bitwisemanuplation;

public class hammingWight {
    public static void main(String[] args) {
        int ans = hammingWeight(11);
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            System.out.println("Before: " + Integer.toBinaryString(n));
            n = n & (n - 1); // remove lowest 1 bit
            System.out.println("After: " + Integer.toBinaryString(n));
            System.out.println(n);
            count++;
        }
        return count;
    }

}
