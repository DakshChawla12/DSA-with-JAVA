public class commonInThreeSorted {
    
    public static int findCommon(int[]arr , int[]brr , int[]crr){
        int a = arr.length , b = brr.length , c = crr.length;
        int count = 0;
        int i = 0 , j = 0, k = 0;
        while(i < a && j < b && k < c ){
            if(arr[i] == brr[j] && brr[j] == crr[k]){
                count++;
                i++;j++;k++;
            }
            else if(brr[j] > arr[i]) i++;
            else if(crr[k] > brr[j]) j++;
            else k++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 20, 40, 80};
        int[] brr = {6, 7, 20, 80, 100};
        int[] crr = {3, 4, 15, 20, 30, 70, 80, 120};

        int count = findCommon(arr, brr, crr);
        System.out.println("Number of common elements: " + count);
    }

}
