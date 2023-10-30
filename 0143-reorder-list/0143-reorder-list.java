class Solution {
    public void reorderList(ListNode head) {
      ListNode slow=head,fast=head,temp=head;
      while(fast.next!=null && fast.next.next!=null)
      {
          fast=fast.next.next;
          slow=slow.next;
      }  
      ListNode next=null,prev=null,current=slow;
      while(current!=null)
      {
          next=current.next;
          current.next=prev;
          prev=current;
          current=next;
      }
      ListNode p=temp,q=prev;
      while(prev!=null && temp!=null)
      {                 
          p=p.next;                
          q=q.next;
          temp.next=prev;
          prev.next=p;   
          temp=p;    
          prev=q;
      }
    }
}