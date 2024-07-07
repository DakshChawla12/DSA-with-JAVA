public class bitManipulation {
    
     // check if a number is odd or even(odd numbers ka least significant bit 1 hota h aur even ka 0 hota h)
    // toh bss least significant bit nikaal k pta chl jaayega ki odd h ya even
    public static void oddEven(int n){
        if((n & 1) == 0) System.out.println("even " + (n & 1));
        else System.out.println("odd " + (n & 1));
    }

    public static int get_ithBit(int n , int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0) return 0;
        return 1;
    }

    public static int set_ithBit(int n , int i){
        int bitMask = 1<<i;
        int ans = n | bitMask;
        return ans;
    }

    public static int clear_ithBit(int n , int i){
        int bitMask = 1<<i;
        int ans = n & (~bitMask);
        return ans;
    }

    public static int update_ithBit(int n , int i , int newBit){
        if(newBit == 0) return clear_ithBit(n, i);
        else return set_ithBit(n, i);
    }

    public static int clearLast_iBits(int n , int i){
        int bitMask = -1<<i;
        int ans = n & (bitMask);
        return ans;
    }
    public static void main(String[] args) {
        // System.out.println(~5); // one's complement
        //System.out.println(~5 & 1);

        // << --> binary left shift
        // >> --> binary right shift

        // left shift a to 2 bits or places  
        // kisi number ko left shift krte h toh uska answer hota h a * 2^b
        //System.out.println(5<<2); // a << b 

        // right shift a to 2 bits or places 
         // kisi number ko right shift krte h toh uska answer hota h a/2^b
        //  System.out.println(5>>2); // a >> b 


        
        // oddEven(7);
        // System.out.println(get_ithBit(10, 2));
        // System.out.println(set_ithBit(10, 2));
        // System.out.println(clear_ithBit(10, 1));
//        System.out.println(clearLast_iBits(15, 2));

        buyAndSellStock temp = new buyAndSellStock();
        int[]arr = {7,1,5,3,6,2};
        System.out.println(buyAndSellStock.maxProfit(arr));
    }

}
