// isme no backtracking
public class mazePaths_2directions {

    public static int maze(int sr , int sc , int er , int ec){
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;
        // total ways from a cell will always be sum of the ways from right cell and bottom cell
    
        int rightWays = maze(sr, sc+1, er, ec);
        int downWays = maze(sr+1, sc, er, ec);
        int totalWays = rightWays + downWays;

        return totalWays;
    }

    public static void print(int sr , int sc , int er , int ec , String res){
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec){
            System.out.println(res);
            return;
        }
        // go right
        print(sr, sc+1, er, ec, res+"R");
        // go down
        print(sr+1, sc, er, ec, res+"D");
    }

    public static void main(String[] args) {
        int rows = 3 , cols = 3;
        // int count = maze(1,1,rows,cols);
        // System.out.println(count);
        print(0, 0, rows-1, cols-1, "");
    }

}
