import java.util.*;

public class first_neg_in_window_sizeK {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K){
        long[]res = new long[N-K+1];
        Queue<Integer>q = new LinkedList<>();

        for(int i = 0; i < N; i++){ // addiNg -ve value iNdices iN queue
            if(A[i] < 0){
                q.add(i);
            }
        }

        for(int i = 0; i < N-K+1; i++){ // wiNdow i+K-1 tKK Ki hogi
            if(q.size() > 0 && q.peek() < i) q.remove();
            
            if(q.size() > 0 && q.peek() <= i+K-1){
                res[i] = A[q.peek()];
            } 
            else if(q.size() == 0) res[i] = 0;
            else res[i] = 0;
                
            
        }
        return res;
    }

}
