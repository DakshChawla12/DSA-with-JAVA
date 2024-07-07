
public class findSqrt {

    public static int getSqrt(long n){
        long s = 1;
        long e = n;
        long mid = s + (e - s)/2;

        long ans = -1;

        while(s <= e){
            if(mid*mid <= n){
                ans = mid;
                s = mid+1;
            }
            else if(mid*mid > n){
                e = mid-1;
            }
            mid = s + (e - s)/2;
        }
        return (int)ans;
    }

    public static int calcPower(int mid, int m , int n){
        int ans = 1;
        for(int i = 1; i <= n; i++){
            ans *= mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }

    public static int getNthRoot(int m, int n){
        int s = 1 , e = m;
        int mid = s + (e - s)/2;

        while(s <= e){
            int Nroot = calcPower(mid, m, n);
            if(Nroot == 1){
                return mid;
            }
            else if(Nroot == 0){
                s = mid + 1;
            }
            else{
                e = mid-1;
            }
            mid = s + (e - s)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int m = 16 , n = 4;
        System.out.println(getNthRoot(m, n));
    }

}
