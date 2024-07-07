import java.util.*;
// ulp = ultimate parent

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

public class DisjointSet {

    public static void main(String[] args) {
        Disjoint_Set ds = new Disjoint_Set(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
    }

}
