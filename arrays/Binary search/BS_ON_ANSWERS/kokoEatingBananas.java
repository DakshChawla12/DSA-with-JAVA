
public class kokoEatingBananas {

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        int mid = low + (high - low)/2;
        int ans = -1;
        //apply binary search:
        while (low <= high) {
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low)/2;
        }
        return ans;
    }   
    public static void main(String[] args) {
        int[]arr = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(arr, h));
    }

}
