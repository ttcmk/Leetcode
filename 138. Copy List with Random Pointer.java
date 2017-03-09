/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/



/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode q = newHead;
        
        map.put(p,q);
        p = p.next;
        
        while(p != null){
            q.next = new RandomListNode(p.label);
            map.put(p,q.next);
            q = q.next;
            p = p.next;
        }
        
        p = head;
        q = newHead;
        
        while(p != null){
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        
        return newHead;
        
        
    }
}
