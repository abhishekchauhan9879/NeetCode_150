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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondList = slow.next;
        slow.next=null;

        ListNode first=head;
        ListNode second=reverseLL(secondList);

        while(second!=null){

            ListNode fNext=first.next;
            ListNode sNext=second.next;
            first.next=second;
            second.next=fNext;

            first=fNext;
            second=sNext;
        }

    }

    private ListNode reverseLL(ListNode head){
        if(head==null)  return null;

        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
