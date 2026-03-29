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
        if(lists.length == 0)   return null;

        int interval=1;
        int k=lists.length;

        while(interval < k){

            for(int i=0;i+interval<k;i+=interval*2){
                lists[i]=merge(lists[i],lists[i+interval]);
            }

            interval*=2;
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                curr.next=new ListNode(l1.val);
                l1=l1.next;
            }else{
                curr.next=new ListNode(l2.val);
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next = (l1!=null)?l1:l2;
        return dummy.next;
    }
}
