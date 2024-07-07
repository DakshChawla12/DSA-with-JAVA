public class Sort_Colours {

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

    public Node color_Sort(Node head) {
        if (head == null || head.next == null) {
            return head; // If the list has zero or one element, it's already sorted
        }
    
        Node zero = new Node(0);
        Node one = new Node(0);
        Node two = new Node(0);
    
        Node zeroTail = zero;
        Node oneTail = one;
        Node twoTail = two;
    
        Node temp = head;
    
        while (temp != null) {
            if (temp.value == 0) {
                Node res = new Node(0);
                zeroTail.next = res;
                zeroTail = res;
            } else if (temp.value == 1) {
                Node res = new Node(1);
                oneTail.next = res;
                oneTail = res;
            } else {
                Node res = new Node(2);
                twoTail.next = res;
                twoTail = res;
            }
            temp = temp.next;
        }
    
        

        if(one.next == null && two.next != null){
            zeroTail.next = two.next;
            twoTail.next = null;
        }
        else{
            zeroTail.next = one.next;
        }

        if(two.next == null){
            oneTail.next = null;
        }
        else{
            oneTail.next = two.next;
        }
        return zero.next;
    }
    

    public static void main(String[] args) {
        Sort_Colours ls = new Sort_Colours();

        ls.insertAtTail(0);
        ls.insertAtTail(1);
        ls.insertAtTail(2);
        ls.insertAtTail(0);
        ls.insertAtTail(1);
        ls.insertAtTail(2);

        ls.display(ls.head);
        System.out.println();

        Node res = ls.color_Sort(ls.head);
        ls.display(res);
    }

}
