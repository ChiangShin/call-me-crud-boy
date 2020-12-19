package com.chiangshin.arithmetic.exercise;

/**
 * Definition for singly-linked list.
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if (l1.val <=  l2.val){
                cur.next=l1;
                l1 = l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1:l2;
        return head.next;
    }
}