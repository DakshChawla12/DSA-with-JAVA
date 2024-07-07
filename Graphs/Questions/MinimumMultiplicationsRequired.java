package Questions;
import java.util.*;
public class MinimumMultiplicationsRequired {

    class pair{
        int node;
        int steps;
        pair(int curr , int s){
            this.node = curr;
            this.steps = s;
        }
    }

    public int minSteps(int start , int end , int[]arr){

        int n = arr.length;

        Queue<pair>q = new LinkedList<>();
        q.offer(new pair(start,0));

        // Create a dist array to store the no. of multiplications to reach
        // a particular number from the start number.
        int[]dist = new int[100000];
        Arrays.fill(dist,(int)1e9);
        dist[start] = 0;

        int mod = 100000;

        // Multiply the start no. with each of numbers in the arr
        // until we get the end no.
        while(!q.isEmpty()){

            pair p = q.poll();
            int node = p.node;
            int steps = p.steps;

            for(int i = 0; i < n; i++){
                int num = (arr[i]*node)%mod;
                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if(dist[num] > steps + 1){
                    dist[num] = steps + 1;
                }
                // Whenever we reach the end number
                // return the calculated steps
                if(num == end) return steps+1;
                q.offer(new pair(num,steps+1));
            }

        }
        return -1;
    }

}
