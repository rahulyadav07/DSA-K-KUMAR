package Hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(uniqueChar(str));
    }
    private static int uniqueChar(String str) {
        if (str.isEmpty()) return -1;

        Map<Character, Integer> freqMap = new HashMap<>();


        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }


        for (int i = 0; i < str.length(); i++) {
            if (freqMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


}
