public class RotateRight {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode nthNode(ListNode node , int k){
        int cnt = 1;
        while(node != null){
            if(cnt == k) return node;
            node = node.next;
            cnt++;
        }
        return node;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int size = 1;
        ListNode tail = head;

        // Count the size of the list and find the tail
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        // Adjust k if it's larger than the size
        k = k % size;
        if (k == 0)
            return head;

        // Connect the tail to the head to form a loop
        tail.next = head;

        // Find the new tail node after rotation
        ListNode newTail = nthNode(head, size - k);

        // Head of the rotated list will be the node after newTail
        head = newTail.next;

        // Break the connection from newTail to head
        newTail.next = null;

        return head;
    }

}
