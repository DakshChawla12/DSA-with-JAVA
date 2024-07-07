import java.util.*;

public class Reverse_A_Queue {

    public static void revvQueue(Queue<Integer>q){
        Stack<Integer>st = new Stack<>();

        while(q.size() > 0){
            st.push(q.remove());
        }
        while(st.size() > 0){
            q.add(st.pop());
        }
    }
    public static void main(String[] args){

        Queue<Integer>q = new LinkedList<>();
        for(int i = 1; i <= 5; i++){
            q.add(i);
        }
        System.out.println(q);
        revvQueue(q);
        System.out.println(q);
    }

}