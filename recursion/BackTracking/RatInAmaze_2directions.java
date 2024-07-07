// isme no backtracking

public class RatInAmaze_2directions {
    
    public static void print(int sr , int sc , int er , int ec , String res , int[][]maze){
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec){
            System.out.println(res);
            return;
        }
        if(maze[sr][sc] == 0) return;
        // go right
        print(sr, sc+1, er, ec, res+"R", maze);
        // go down
        print(sr+1, sc, er, ec, res+"D", maze);
    }

    public static void main(String[] args) {
        int rows = 4 , cols = 6;
        int[][]maze = {
                    {1,0,1,1,1,1},  
                    {1,1,1,1,0,1},
                    {0,1,1,1,1,1},
                    {0,0,1,0,1,1}};
        
        print(0, 0, rows-1, cols-1, "",maze);
    }

}
