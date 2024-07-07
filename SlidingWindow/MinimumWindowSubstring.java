import java.util.*;
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        int n = s.length(), m = t.length();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sIdx = -1, cnt = 0;

        Map<Character, Integer> hash = new HashMap<>();

        for (char ch : t.toCharArray()) {
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        }

        while (r < n) {
            char ch = s.charAt(r);
            if (hash.containsKey(ch)) {
                hash.put(ch, hash.get(ch) - 1);
                if (hash.get(ch) >= 0) {
                    cnt++;
                }
            }

            while (cnt == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIdx = l;
                }

                char leftChar = s.charAt(l);
                if (hash.containsKey(leftChar)) {
                    hash.put(leftChar, hash.get(leftChar) + 1);
                    if (hash.get(leftChar) > 0) {
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }
        if (sIdx == -1) return "";
        return s.substring(sIdx, sIdx + minLen);
    }

}
