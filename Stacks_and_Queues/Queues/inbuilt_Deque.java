import java.util.*;

/* doubly ended queue */
/* allows insertion and deletion from starting and from end */

/* 1) If you need a deque with efficient insertions and removals
at both ends and can tolerate slower random access, choose LinkedList.

2) If you need a deque with fast insertions and removals
 at both ends, as well as efficient random access, choose ArrayDeque. */

public class inbuilt_Deque {

        public static void main(String[] args) {
            Deque<Integer>dec = new ArrayDeque<>();
            dec.add(0);
            dec.add(1);
            dec.add(2);

            System.out.println(dec.peek());

            System.out.println(dec);

            dec.addFirst(99);
            dec.addLast(100);

            System.out.println(dec);
            System.out.println(dec.remove());
            System.out.println(dec.removeAll(dec));
        }

}