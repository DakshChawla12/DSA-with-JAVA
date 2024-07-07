public class reverseInKgroups {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseLL(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;

    }

    public ListNode getKthNode(ListNode node , int k){

        int cnt = 1;
        while(node != null && cnt < k){
            node = node.next;
            cnt++;;
        }
        return node;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null){

            ListNode kthNode = getKthNode(temp,k);

            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);

            if(temp == head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;

    }

}
