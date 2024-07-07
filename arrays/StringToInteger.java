public class StringToInteger {
    
    public static long stringToLong(String str) {
        long ans = 0;

        for (int i = 0; i < str.length(); i++) {
            int current = str.charAt(i) - '0';
            ans = (ans * 10) + current;
        }

        return ans;
    }

}
