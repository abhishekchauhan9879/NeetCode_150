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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)  return null;

        ListNode dummy = new ListNode();
        dummy.next=head;

        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;

            for(int i=0;i<k && kth!=null ;i++){
                kth=kth.next;
            }
            if(kth==null) break;
            //we found the nextKth node now
            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;

            ListNode prev=nextGroup;
            ListNode curr=groupStart;

            while(curr!=nextGroup){
                ListNode temp = curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }

            prevGroup.next=kth;//4
            prevGroup=groupStart;//1
        }

        return dummy.next;
    }
}
