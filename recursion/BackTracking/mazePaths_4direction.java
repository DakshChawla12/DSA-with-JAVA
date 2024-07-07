public class mazePaths_4direction {
    
    public static void print(int sr , int sc , int er , int ec , String res , boolean[][]isVisited){
        
        if(sr < 0 || sc < 0) return;
        if(sr > er || sc > ec) return;
        if(isVisited[sr][sc] == true) return; // agrr cell true marked h mtlb already vaha gye they phle to return krr jao

        if(sr == er && sc == ec){
            System.out.println(res);
            return;
        }

        /*
            basic mtlb --> 
            1) phle uss jagah(current cell) p mark lgao(true krdo)
            2) fir uss cell k liye saari required calls lgao
            3) saari calls lgaane k baad taaki vo cell aagey use ho paaye to waapis uss cell ser mark htado(false krdo)
         */



        isVisited[sr][sc] = true;// phle isliye mark krr rahe kyunki fir uss call se jitni bhi calls bjegi unme bhi true mark ho rkha hoha
        // go right
        print(sr, sc+1, er, ec, res+"R", isVisited);
        // go down
        print(sr+1, sc, er, ec, res+"D", isVisited);
        // go left
        print(sr, sc-1, er, ec, res+"L", isVisited);
        // go up
        print(sr-1, sc, er, ec, res+"U", isVisited);
        // backtracking --> jbb uss cell k liye saari calls lgg gyi h toh usko further use kr ske isliye vaapis usko false mark krdo
        isVisited[sr][sc] = false;
    }

    public static void main(String[] args) {
        int rows = 3 , cols = 3;
        // int count = maze(1,1,rows,cols);
        // System.out.println(count);
        boolean[][]isVisited = new boolean[rows][cols]; // --> by default false he hoga hrr cell m
        print(0, 0, rows-1, cols-1, "", isVisited);
    }

}
