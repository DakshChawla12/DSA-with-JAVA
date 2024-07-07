
public class LL {
    
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

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
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

    public void insertAtPosition(int data, int position) {
        if (position == 1) {
            insertAtHead(data);
            return;
        }

        Node temp = head;
        int count = 1;

        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            insertAtTail(data);
            return;
        }

        Node nodeToInsert = new Node(data);

        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;
    }

    public void deleteNode(int position) {
        if (position <= 0 || head == null) {
            System.out.println("Invalid position or empty list");
            return;
        }
    
        if (position == 1) {
            Node nodeToDelete = head;
            head = head.next;
            // The memory of nodeToDelete will be freed by the garbage collector
        } 
        else {
            Node current = head;
            Node prev = null;
            int currentPosition = 1;
    
            while (currentPosition < position && current != null) {
                prev = current;
                current = current.next;
                currentPosition++;
            }
    
            if (current == null) {
                System.out.println("Position is greater than the length of the list");
            } else {
                prev.next = current.next;
                // The memory of the deleted node (current) will be freed by the garbage collector
            }
        }
    }
    
    public Node getMid(Node head){
        if (head == null || head.next == null) {
            return head;
        }
    
        Node slow = head;
        Node fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        return slow;
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
        LL list = new LL();
        for(int i = 1; i <= 5; i++){
            list.insertAtTail(i);
        }
        list.insertAtPosition(999, 3);
        list.display(list.head);
        
    }
}
