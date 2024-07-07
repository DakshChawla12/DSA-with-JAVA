

class removeFromEnd {

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

    public  Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
    
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
    
        return prev;
    }

    public  Node removeLast(Node head , int n){
        if (head == null || (head.next == null && n == 1)) {
            if (n == 1) {
                return null; // Return null if the list contains only one node and n is 1 (remove the only node)
            }
            return head; // Return the head as is if the list is empty or n is equal to the list size
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node temp = reverseList(head);
        Node originalTemp = temp; // Keep track of the original temp

        int count = 1;

        while(temp != null && count < n){
            temp = temp.next;
            dummy = dummy .next;
            count++;
        }
        
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        else if (temp == null) {
            head = head.next; // Remove the first node
        }

        Node result = reverseList(originalTemp); // Reverse the modified list back

        if (n == 1) {
            result = result.next; // Remove the last node when n is equal to the list size
        }
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
        removeFromEnd ls = new removeFromEnd();
        ls.insertAtTail(1);
        ls.insertAtTail(2);
        ls.insertAtTail(3);
        ls.insertAtTail(4);
        ls.insertAtTail(5);

        Node res = ls.removeLast(ls.head, 2);

        ls.display(res);
    }
}