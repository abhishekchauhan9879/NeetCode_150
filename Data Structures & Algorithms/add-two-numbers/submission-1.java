/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;

        ListNode curr1=l1;
        ListNode curr2=l2;
        ListNode dummy= new ListNode(-1);
        ListNode res=dummy;
        while(curr1!=null && curr2!=null){
            int sum=(curr1.val+curr2.val+carry)%10;
            carry=(curr1.val+curr2.val+carry)/10;
            res.next =new ListNode(sum);
            curr1=curr1.next;
            curr2=curr2.next;
            res=res.next;
        }

        while(curr1!=null){
            int sum=(curr1.val+carry)%10;
            carry=(curr1.val+carry)/10;
            res.next= new ListNode(sum);
            curr1=curr1.next;
            res=res.next;
        }

        while(curr2!=null){
            int sum=(curr2.val+carry)%10;
            carry=(curr2.val+carry)/10;
            res.next= new ListNode(sum);
            curr2=curr2.next;
            res=res.next;
        }
        if(carry>0){
            res.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
