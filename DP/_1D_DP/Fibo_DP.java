package _1D_DP;

public class Fibo_DP {

    public static int fibo_memoization(int n , int[]fib){

        if(n == 0) return 0;
        if(n == 1) return 1;

        if(fib[n] != 0){
            return fib[n];
        }
        fib[n] = fibo_memoization(n-2,fib) + fibo_memoization(n-1,fib);
        return fib[n];

    }

    public static int fibo_tabulation(int n){
        int[]fib = new int[n+1];

        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static int fibo_tabulationOpt(int n){

        int prev2 = 0 , prev = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 10;
        int[]fib = new int[n+1];
        System.out.println(fibo_tabulationOpt(n));
    }

}
