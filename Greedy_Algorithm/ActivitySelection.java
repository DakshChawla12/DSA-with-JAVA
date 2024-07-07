import java.util.Arrays;
import java.util.Comparator;

class activityComparator implements Comparator<activity>{
    @Override
    public int compare(activity a , activity b) {
        return a.finish - b.finish;
    }
}

public class ActivitySelection {

    public static int helper(activity[]arr , int n){
        Arrays.sort(arr,new activityComparator());
        int c = 1 , e = arr[0].finish;

        for (activity Activity : arr) {
            if (Activity.start > e) {
                c++;
                e = Activity.finish;
            }
        }
        return c;
    }
    public static int activitySelection(int[] start, int[] end, int n) {

        activity[]arr = new activity[n];
        for(int i = 0; i < start.length; i++){
            arr[i] = new activity(start[i],end[i]);

        }

        return helper(arr,n);

    }

    public static void main(String[] args) {
        int[]a = {7, 6, 2, 7, 3};
        int[]b = {10, 6, 10, 9, 5};

        System.out.println(activitySelection(a,b,a.length));
    }

}
