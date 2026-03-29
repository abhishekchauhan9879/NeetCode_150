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
        List<Integer> values = new ArrayList<>();

        //Step 1. flatten and save to the list
        for(ListNode head: lists){
            while(head!=null){
                values.add(head.val);
                head=head.next;
            }
        }
        //Step 2. Lets sort the list
        Collections.sort(values);

        //Step 3. Build the LL
        ListNode dummy = new ListNode();
        ListNode curr=dummy;
        for(int val:values){
            curr.next=new ListNode(val);
            curr=curr.next;
        }
        return dummy.next;
    }
}
