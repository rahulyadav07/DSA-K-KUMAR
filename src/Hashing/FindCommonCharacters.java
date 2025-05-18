package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] strArray = {"bella","label","roller"};
       List<String> s =  findCommonCharacter(strArray);
        for (String str:s) {
            System.out.println(str);
        }
    }

    /**
     *
     */
    private static List<String> findCommonCharacter(String[] strArray) {
        int[] minFreq=  new int[26];

        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String str:strArray) {

            int[] currentStringFreq = new int[26];
            for(char c :str.toCharArray()) {
                currentStringFreq[c-'a']++;
            }
            for (int i =0;i<26;i++) {
                minFreq[i] = Math.min(minFreq[i], currentStringFreq[i]);
            }

        }
        List<String> result = new ArrayList<>();
        for (int i =0;i<26;i++) {
            while (minFreq[i]>0) {
                result.add(String.valueOf((char) (i+'a')));
                minFreq[i]--;
            }
        }
        return result;
    }
}
