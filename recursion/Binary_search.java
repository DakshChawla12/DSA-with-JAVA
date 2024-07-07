public class Binary_search {
    
    public static boolean search(int[]arr , int s , int e , int key){
        if(s > e){
            return false;
        }

        int mid = s + (e - s)/2;

        if(arr[mid] == key){
            return true;
        }
        else if(arr[mid] > key){
            e = mid - 1;
            return search(arr, s, e, key);
        }
        else{
            s = mid + 1;
            return search(arr, s, e, key);
        }
    }

    public static int searchInRotated(int[]arr , int s , int e , int key){
        if(s > e){
            return -1;
        }

        int mid = s + (e - s)/2;

        if(arr[mid] == key){
            return mid;
        }

        else if(arr[s] <= arr[mid]){
            if(arr[s] <= key && arr[mid] >= key){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
            return searchInRotated(arr, s, e, key);
        }
        else{
            if(arr[mid] <= key && arr[e] >= key){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
            return searchInRotated(arr, s, e, key);
        }
    }

    public static void main(String[] args) {
        int[]arr = new int[]{5,6,7,8,1,2,3};
        int ans = searchInRotated(arr, 0, 6, 3);
        System.out.println(ans);
    }

}
