import java.util.*;
/* insertion is happening at back and removing is happening at front */
/* it is implemented using linked list in java collections */
/* it also have a head and a tail like a linked list */

public class inbuilt_Queue {

        public static void main(String[] args) {
            Queue<Integer>q = new LinkedList<>();
            q.add(3);
            q.add(4);
            q.add(5);
            q.add(6);
            q.add(0);
            // peek gets the first element and nothing else
            System.out.println(q.peek());
            // remove removes the 1st element and returns it
            System.out.println(q.remove());

            System.out.println(q.peek());
            System.out.println(q.remove());
        }

}