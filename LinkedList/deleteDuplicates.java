import java.util.HashMap;

public class deleteDuplicates {
    
    public Node head;
    public Node tail;

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public Node DeleteDuplicates(Node head) { // isme order nahi maintain ho raha
        Node temp = head;

        HashMap<Integer,Integer>mpp = new HashMap<>();

        while(temp != null){
            int val = temp.value;
            mpp.put(val, mpp.getOrDefault(val, 0) + 1);
            temp = temp.next;
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        for(int x : mpp.keySet()){
            int ele = mpp.get(x);
            if(ele == 1){
                Node res = new Node(x);
                tail.next = res;
                tail = tail.next;
            }
        }

        Node result = dummy.next;
        dummy.next = null;
        
        return result;
    }

    public Node delete_Duplicates(Node head) {
        if (head == null || head.next == null) {
            return head; // Handling empty or single-node list
        }

        Node current = head;

        while (current != null) {
            Node temp = current;

            // Remove all instances of current value after this node
            while (temp.next != null) {
                if (temp.next.value == current.value) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }

            current = current.next; // Move to the next unique element
        }

        return head;
    }


    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        deleteDuplicates ls = new deleteDuplicates();
        ls.insertAtTail(1);
        ls.insertAtTail(1);
        ls.insertAtTail(1);
        ls.insertAtTail(1);
        ls.insertAtTail(2);
        ls.insertAtTail(3);

        ls.display(ls.head);
        System.out.println();
        Node res = ls.DeleteDuplicates(ls.head);
        ls.display(res);

    }

}


