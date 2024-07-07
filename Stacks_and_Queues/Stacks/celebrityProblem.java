import java.util.*;

public class celebrityProblem {
    
    public static int celebrity(int M[][] , int n){

        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < n; i++){ // saare indices ko stack m daaldo
            st.push(i);
        }
        while(st.size() > 1){

            int v1 = st.pop(); // top value
            int v2 = st.pop(); // 2nd from top

            if(M[v1][v2] == 0){ // shyd v1 celeb ho skta h , v2 toh bilkul nhi ho skta
                st.push(v1);
            }
            else if(M[v2][v1] == 0){ // shyd v2 celeb ho skta h , v1 toh bilkul nhi ho skta
                st.push(v2);
            }

        }

        // case 1
        if(st.size() == 0) return -1; // mtlb koi celebrity nhi h

        int potential = st.pop(); // agr stack ka size 1 hota h toh
        
        for(int i = 0; i < n; i++){ // travelling in potential element's row
            if(M[potential][i] == 1) return -1; // checking for 1 because agr potential kisi ko jaanta hoga toh vo celebrity nhi hoga
        }
        for(int i = 0; i < n; i++){ // travelling in potential element's column
            if(i == potential) continue;
            if(M[i][potential] == 0) return -1; // checking for 0 because agr potential ko khud ko chorh k agr koi usse na jaanta hua toh vo celebrity nhi hoga
        }
        return potential;
    }

}
