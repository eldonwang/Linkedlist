 class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public static boolean isPalindrome(ListNode head) {
        if(head == null||head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick.next != null){
            slow = slow.next;
            quick = quick.next.next == null?quick.next:quick.next.next;
        }
        reverse(slow);
        ListNode nowQuick = quick;
        while(quick !=null){
         if(quick.val == head.val){
             quick = quick.next;
             head = head.next;
         }
         else if(quick.val != head.val){
             return false;
         }
        }
        reverse(nowQuick);
        return true;
    }
    public static void reverse(ListNode node){
        ListNode pre = null;
        ListNode next = null;
        while(node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
    }
    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.print(isPalindrome(head) + " | ");

        System.out.println("=========================");
    }

}