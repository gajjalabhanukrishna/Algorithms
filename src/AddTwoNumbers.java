import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode current = head;
        int carry = 0;

        while(temp1 != null || temp2 != null){

            int x = temp1 != null ? temp1.val : 0;
            int y = temp2 != null ? temp2.val : 0;

            int sum = carry + x + y;

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;

        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        atn.addTwoNumbers(null, null);
    }
}



 class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
