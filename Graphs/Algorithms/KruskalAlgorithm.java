package Algorithms;
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
class Edge{
    int src ,  dest , weight;
    Edge(int s , int d , int wt){
        this.src = s;
        this.dest = d;
        this.weight = wt;
    }

}
class WeightComparator implements Comparator<Edge> {
    public int compare(Edge edge1, Edge edge2) {
        return edge1.weight - edge2.weight;
    }
}
public class KruskalAlgorithm {

    public int spanningTree(int V , ArrayList<ArrayList<ArrayList<Integer>>> adj){

        ArrayList<Edge>edges = new ArrayList<>();
        // Iterate over all vertices
        for (int i = 0; i < V; i++) {
            // Iterate over all adjacent vertices of the current vertex
            for (int j = 0; j < adj.get(i).size(); j++) {
                // Extracting source, destination, and weight of the edge
                int s = adj.get(i).get(j).get(0);
                int d = adj.get(i).get(j).get(1);
                int wt = adj.get(i).get(j).get(2);

                // Creating an Edge object and adding it to the list of edges
                Edge temp = new Edge(s, d, wt);
                edges.add(temp);
            }
        }

        Disjoint_Set ds = new Disjoint_Set(V);  // Creating a disjoint set data structure
        WeightComparator comparator = new WeightComparator();  // Creating a comparator to sort edges by weight
        Collections.sort(edges,comparator);  // Sorting edges by weight

        int mstWt = 0;

        for(int i = 0; i < edges.size(); i++){
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            int wt = edges.get(i).weight;

            if(ds.findParent(u) != ds.findParent(v)){ // checking if they are already connected or not
                mstWt += wt;
                ds.unionBySize(u,v); // connect them if not
            }
        }
        return mstWt;
    }

}
