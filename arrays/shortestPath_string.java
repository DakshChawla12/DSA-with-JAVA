

public class shortestPath_string {

    public static float shortest_dist(String path){
        int x = 0 , y = 0;
        for(int i = 0; i < path.length(); i++){
            char ch = path.charAt(i);

            if(ch == 'N') y++; // north
            else if(ch == 'S') y--; // south
            else if(ch == 'E') x++; // east
            else x--; // west
        }
        int x_sq = x*x , y_sq = y*y;
        return (float)Math.sqrt(x_sq + y_sq);
    }
    
    public static void main(String[] args) {

        String path = "WNEENESENNN";
        float res = shortest_dist(path);
        System.out.println(res);
    }

}