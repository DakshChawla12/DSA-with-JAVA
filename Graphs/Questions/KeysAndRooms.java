package Questions;
import java.util.*;
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int V = rooms.size();

        int[]isVisited = new int[V];
        isVisited[0] = 1;

        Queue<Integer>q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it : rooms.get(node)){
                if(isVisited[it] == 0){
                    isVisited[it] = 1;
                    q.offer(it);
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(isVisited[i] == 0) return false;
        }
        return true;
    }

}
