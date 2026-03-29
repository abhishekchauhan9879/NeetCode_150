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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        
        // Instead of adding all the numbers, lets only add head of the LL
        for(ListNode head:lists){
            if(head!=null){
                pq.offer(head);
            }
        }

        //Now we have the head of the LL sorted 
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode smallestHead = pq.poll();
            curr.next=new ListNode(smallestHead.val);
            curr=curr.next;

            if(smallestHead.next!=null){
                pq.offer(smallestHead.next);
            }
        }
        return dummy.next;
    }
}
