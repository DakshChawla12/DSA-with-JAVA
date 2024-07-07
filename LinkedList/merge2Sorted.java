

public class merge2Sorted {

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

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static merge2Sorted merge(Node head1 , Node head2){
        merge2Sorted result = new merge2Sorted();

        
        Node curr1 = head1;
        Node curr2 = head2;

        while(curr1 != null && curr2 != null){
            if(curr1.value > curr2.value){
                result.insertAtTail(curr2.value);
                curr2 = curr2.next;
                
            }
            else{
                result.insertAtTail(curr1.value);
                curr1 = curr1.next;
                
            }
        }

        while(curr1 != null){
            result.insertAtTail(curr1.value);
            curr1 = curr1.next;
            
        }

        while(curr2 != null){
            result.insertAtTail(curr2.value);
                curr2 = curr2.next;
                
        }
        return result;
    }

    public static void main(String[] args) {
        merge2Sorted ls1 = new merge2Sorted();
        merge2Sorted ls2 = new merge2Sorted();

        ls1.insertAtTail(1);
        ls1.insertAtTail(3);
        ls1.insertAtTail(5);

        ls2.insertAtTail(2);
        ls2.insertAtTail(4);
        ls2.insertAtTail(6);

        merge2Sorted res = merge(ls1.head , ls2.head);
        res.display(res.head);
    }

}