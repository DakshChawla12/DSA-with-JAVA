package BackTracking;

import java.util.ArrayList;

public class Rat_In_A_Maze {
    
    public static void print(int sr , int sc , int er , int ec , String res , int[][]maze, ArrayList<String>ls){
        if(maze[er][ec] == 0) return;
        if(sr < 0 || sc < 0) return;
        if(sr > er || sc > ec) return;
        if(maze[sr][sc] == -1) return; // agrr cell -1 marked h mtlb already vaha gye they phle to return krr jao

        if(sr == er && sc == ec){
            ls.add(res);
            return;
        }

        if(maze[sr][sc] == 0) return;


        maze[sr][sc] = -1;// phle isliye mark krr rahe kyunki fir uss call se jitni bhi calls bjegi unme bhi true mark ho rkha hoha
        // go right
        print(sr, sc+1, er, ec, res+"R", maze,ls);
        // go down
        print(sr+1, sc, er, ec, res+"D", maze,ls);
        // go left
        print(sr, sc-1, er, ec, res+"L", maze,ls);
        // go up
        print(sr-1, sc, er, ec, res+"U", maze,ls);
        // backtracking --> jbb uss cell k liye saari calls lgg gyi h toh usko further use kr ske isliye vaapis usko false mark krdo
        maze[sr][sc] = 1;
    }

    public static void main(String[] args) {
        int rows = 2 , cols = 2;
        int[][]maze = {
                    {1,0},
                    {1,0}};
        ArrayList<String>ls = new ArrayList<>();
        print(0, 0, rows-1, cols-1, "",maze,ls);
        System.out.println(ls);
    }

}
