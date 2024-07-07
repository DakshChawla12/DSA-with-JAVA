import java.util.ArrayList;

public class graphCreation__adjacencyList {

    // *** Edge Class ***
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

    public static void createGraph(ArrayList<Edge>[] graph){

        // this is to replace all the null present at every index
        // and create a new ArrayList at every index
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }


        graph[0].add(new Edge(0,2,2));  // Add a new edge connecting vertex 0 to vertex 2 in the graph.

        graph[1].add(new Edge(1,2,10));  // Add a new edge connecting vertex 1 to vertex 2 in the graph.
        graph[1].add(new Edge(1,3,0));  // Add a new edge connecting vertex 1 to vertex 3 in the graph.

        graph[2].add(new Edge(2,0,2));  // Add a new edge connecting vertex 2 to vertex 0 in the graph.
        graph[2].add(new Edge(2,1,10));  // Add a new edge connecting vertex 2 to vertex 1 in the graph.
        graph[2].add(new Edge(2,3,-1));  // Add a new edge connecting vertex 2 to vertex 3 in the graph.

        graph[3].add(new Edge(3,1,0));  // Add a new edge connecting vertex 3 to vertex 1 in the graph.
        graph[3].add(new Edge(3,2,-1));  // Add a new edge connecting vertex 3 to vertex 2 in the graph.

    } // *** function to create graph

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // Print vertices with their neighbors
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Edge edge : graph[i]) {
                System.out.println("{" + edge.source + "->" + edge.destination + "} ");
                System.out.println("weight of this edge is --> " + edge.weight);
            }
            System.out.println();
        }

    }

}
