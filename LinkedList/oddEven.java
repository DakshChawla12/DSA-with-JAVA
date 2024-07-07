public class oddEven {
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

    public Node oddEvenList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
    
        Node oddDummy = new Node(0);
        Node evenDummy = new Node(0);
        Node oddTail = oddDummy;
        Node evenTail = evenDummy;
    
        Node temp = head;
        int count = 1;
    
        while (temp != null) {
            if (count % 2 != 0) {        
                oddTail.next = temp;
                oddTail = oddTail.next;
            } else {
                evenTail.next = temp;
                evenTail = evenTail.next;
            }
            temp = temp.next;
            count++;
        }
    
        evenTail.next = null; // Terminate the even list
        oddTail.next = evenDummy.next; // Concatenate odd list with even list
    
        Node result = oddDummy.next;
        oddDummy.next = null; // Clear the dummy nodes
        evenDummy.next = null;
    
        return result;
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
        oddEven ls = new oddEven();

        ls.insertAtTail(1);
        ls.insertAtTail(2);
        ls.insertAtTail(3);
        ls.insertAtTail(4);
        ls.insertAtTail(5);
        ls.display(ls.head);
        System.out.println();
        Node newNode = ls.oddEvenList(ls.head);
        ls.display(newNode);
    }

}
