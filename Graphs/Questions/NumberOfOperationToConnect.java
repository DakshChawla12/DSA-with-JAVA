package Questions;
import java.util.*;
class Disjoint_Set{
    List<Integer>rank = new ArrayList<>();
    List<Integer>parent = new ArrayList<>();
    List<Integer>size = new ArrayList<>();
    public Disjoint_Set(int n){
        for(int i = 0; i <= n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){

        if(node == parent.get(node)){  // if this is satisfied,it means that node is the ultimate parent
            return node;
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node,ultimateParent); // this is the path-compression stepf
        return parent.get(node);
    }

    public void unionByRank(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return; // if the ultimate parents are same nothing to do

        if(rank.get(ulp_u) < rank.get(ulp_v)) parent.set(ulp_u,ulp_v); // if(rank[u] < rank[v]) then attach u to v
        else if(rank.get(ulp_v) < rank.get(ulp_u)) parent.set(ulp_v,ulp_u); // // if(rank[v] < rank[u]) then attach v to u
        else{ // for equal rank
            parent.set(ulp_v,ulp_u);  // just attach v to u
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1); // increase the rank of u by 1
        }
    }

    public void unionBySize(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v); // Making v as parent of u
            size.set(ulp_v,(size.get(ulp_u)+size.get(ulp_v))); // Updating size of v
        }
        else{
            parent.set(ulp_v,ulp_u); // Making u as parent of v
            size.set(ulp_u,(size.get(ulp_u)+size.get(ulp_v))); // Updating size of u
        }

    }

}

public class NumberOfOperationToConnect {

    public int makeConnected(int n, int[][] connections) {

        // Initialize a disjoint set with size n
        Disjoint_Set ds = new Disjoint_Set(n);
        // Number of connections
        int m = connections.length;
        // Counter for redundant connections
        int extra = 0;

        // Iterate through connections
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            // If both computers are already connected, count this connection as extra
            if (ds.findParent(u) == ds.findParent(v)) {
                extra++;
            } else {
                // Otherwise, join the two sets
                ds.unionBySize(u, v);
            }
        }

        // Count the number of distinct connected components
        int nC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                nC++;
            }
        }
        // Minimum cables needed is the number of distinct components minus 1
        int ans = nC - 1;

        // If there are enough extra connections to connect all components, return the minimum cables needed
        if (extra >= ans)
            return ans;
        // Otherwise, it's not possible to connect all computers
        return -1;
    }

}
