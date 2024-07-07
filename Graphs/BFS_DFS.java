import java.util.*;

public class BFS_DFS {

    public static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int src , int dest , int wt){
            this.source = src;
            this.destination = dest;
            this.weight = wt;
        }

    }

    public static void createGraph(ArrayList<Edge>[]graph){

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

//        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[5].add(new Edge(6, 5, 1));


    }

    public static ArrayList<Integer> bfs_traversal(ArrayList<Edge>[]graph , int V , boolean[]isVisited , int start){

        Queue<Integer>q = new LinkedList<>();
        ArrayList<Integer>res = new ArrayList<>();

        q.add(start);

        while(!q.isEmpty()){
            int curr = q.poll();

            if(!isVisited[curr]){
                res.add(curr);
                isVisited[curr] = true; // *** mark the current node true in isVisited array so it
                                        // get printed again

                for(int i = 0; i < graph[curr].size(); i++){ // *** to add all the neighbours of current node
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
        return res;
    }

    public static void DFS_traversal(ArrayList<Edge>[]graph , int curr , boolean[]isVisited){

        if(isVisited[curr]) return;

        System.out.print(curr + " ");
        isVisited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            DFS_traversal(graph , e.destination , isVisited);
        }

    }

    public static void main(String[] args) {
        int V = 7;
        /*

         1 --- 3
        /      | \
        0      |  5 -- 6     *** BFS if start is 0 : 0 1,2,3,4,5,6
        \      | /
         2 --- 4

         */

        ArrayList<Edge>[]graph = new ArrayList[V];
        createGraph(graph);

        boolean[]isVisited = new boolean[graph.length];

//        for(int i = 0; i < V ; i++){  // *** this is required for case of disconnected graphs (BFS)
//            if(!isVisited[i]){
//                System.out.println(bfs_traversal(graph , V , isVisited , i));
//            }
//        }

        for(int i = 0; i < V ; i++){  // *** this is required for case of disconnected graphs (DFS)
            if(!isVisited[i]){
                DFS_traversal(graph,i,isVisited);
            }
        }

    }

}
