public class DLL {
    private Node head;
    private Node tail;
    private int size;

    // Node class
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Constructor
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to insert a node at the head of the list
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to insert a node at the tail of the list
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to insert a node at a given position in the list
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position. Insertion failed.");
            return;
        }

        Node newNode = new Node(data);
        if (position == 1) {
            insertAtHead(data);
        } else if (position == size) {
            insertAtTail(data);
        } else {
            Node current = head;
            int i = 1;

            while (i < position - 1) {
                current = current.next;
                i++;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    // Method to delete a node at a given position in the list
    public void deleteAtPosition(int position) {
    // Check for invalid position
        if (isEmpty() || position < 0 || position >= size) {
            System.out.println("Invalid position. Deletion failed.");
            return;
        }

    // Delete at the beginning of the list
        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null; // Adjust the prev pointer of the new head
            } else {
            // If the list becomes empty after deletion
                tail = null;
            }
        }
    // Delete at the end of the list
        else if (position == size - 1) {
            tail = tail.prev;
            tail.next = null; // Adjust the next pointer of the new tail
        }
    // Delete at any other position
        else {
            Node current = head;
            int i = 0;

        // Traverse the list to the specified position
            while (i < position) {
                current = current.next;
                i++;
            }

        // Adjust pointers to bypass the node being deleted
            current.prev.next = current.next;
            current.next.prev = current.prev;
    }

    // Decrease the size of the list after deletion
        size--;
    }

    public void reverse() {
        Node temp = null;
        Node temp2 = head;
    
        while (temp2 != null) {
            Node next = temp2.next;
            temp2.next = temp;
            temp2.prev = next;
            temp = temp2;
            temp2 = next;
        }
    
        // Update head and tail pointers
        tail = head;
        head = temp;
        // Since it's reversed, the new tail is the original head
    
    }

    // Method to display the contents of the list
    public void display(Node head) {
        
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        for(int i = 1; i <= 5; i++){
            dll.insertAtTail(i);
        }
        // dll.display();
        // dll.insertAtPosition(99, 2);
        // dll.display();
        // dll.insertAtPosition(9999, 1);
        // dll.display();
        // dll.deleteAtPosition(2);
        // dll.display();

        dll.display(dll.head);
        System.out.println();
        System.out.println(dll.head.data + " " + dll.tail.data);
        dll.reverse();
        dll.display(dll.head);
        System.out.println(dll.head.data + " " + dll.tail.data);
        
    }
}
