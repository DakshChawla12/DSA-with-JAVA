import java.util.*;
public class FindkPairsWithSmallestSum {

    static class pair{
        int first;
        int second;
        pair(int a , int b){
            first = a;
            second = b;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>>res = new ArrayList<>();
        PriorityQueue<pair>pq = new PriorityQueue<>(Comparator.comparingInt(p->p.first+p.second));

        for (int j : nums1) {
            for (int value : nums2) {
                pair p = new pair(j, value);
                pq.offer(p);
            }
        }

        int cnt = 0;
        while(cnt < k){
            pair temp = pq.poll();
            List<Integer>ls = new ArrayList<>();
            ls.add(temp.first);
            ls.add(temp.second);
            res.add(ls);
            cnt++;
        }
        return res;
    }

}
