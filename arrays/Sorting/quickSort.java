
public class quickSort {

    public static int partition(int[]arr , int low , int high){

        int pivot = arr[low];
        int i = low , j = high;
        while(i < j){
            while(arr[i] <= pivot && i <= high-1) i++;
            while(arr[j] > pivot && j >= low + 1) j--;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quick_Sort(int[]arr , int low , int high){
        if(low < high){
            int partitionIndex =  partition(arr,low,high);
            quick_Sort(arr, low, partitionIndex-1);
            quick_Sort(arr, partitionIndex+1, high);
        }
    }

    public static void main(String[] args) {
        int[]arr = {3,2,4,1,5};
        quick_Sort(arr, 0, arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
