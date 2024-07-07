import java.util.*;

class SUM_beautyOfString {

    
    public static int calculate_beauty(HashMap<Character, Integer> mpp){
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (Integer value : mpp.values()) {
            if (value > maxi) {
                maxi = value;
            }

            if (value < mini) {
                mini = value;
            }
        }
        return maxi-mini;
    }

    public static int Beauty_String(String s){
        int n = s.length();

        int total_beauty = 0;

        for(int i = 0; i < n; i++){
            HashMap<Character,Integer>mpp = new HashMap<>();
            for(int j = i; j < n; j++){
                mpp.put(s.charAt(j) , mpp.getOrDefault(s.charAt(j),0)+1);
                if((j-i)+1 > 2){
                    total_beauty += calculate_beauty(mpp);
                }
            }
        }
        return total_beauty;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a string --> ");
        String str = input.nextLine();
        int ans = Beauty_String(str);
        System.out.print("total beuty of string --> "+ans);

        input.close();
    }

}