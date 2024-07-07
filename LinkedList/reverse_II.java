public class reverse_II {
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

    Node reverseBetween(Node head, int left, int right) {

        // create a dummy node to mark the head of this list
        Node dummy = new Node(0);
        dummy.next = head;
    
        // make markers for currentNode and for the node before reversing
        Node leftPre = dummy;
        Node currNode = head;
    
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }
    
        // make a marker to node where we start reversing
        Node subListHead = currNode;
    
        Node preNode = null;
        for (int i = 0; i <= right - left; i++) {
            Node nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
    
        // Join the pieces
        leftPre.next = preNode;
        subListHead.next = currNode;
    
        return dummy.next;
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
        reverse_II ls = new reverse_II();

        ls.insertAtTail(1);
        ls.insertAtTail(2);
        ls.insertAtTail(3);
        ls.insertAtTail(4);
        ls.insertAtTail(5);

        Node res = ls.reverseBetween(ls.head , 2 , 4);
        
        ls.display(res);
    }

}











