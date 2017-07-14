//Two Entry:
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
        if(head == null) {
            return head;
        }
        //copy node
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        //deep copy
        cur = head;
        while(cur != null) {
            RandomListNode temp = map.get(cur);
            temp.next = map.get(cur.next);
            temp.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

//one entry
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    //one pass:
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return head;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode cur = head;
        while (cur != null) {
            //create the cur node
            if(!map.containsKey(cur)) {
                RandomListNode copyCur = new RandomListNode(cur.label);
                map.put(cur, copyCur);
                //cur = cur.next;
            }
            //create the next node
            if(cur.next != null && !map.containsKey(cur.next)){
                RandomListNode copyNext = new RandomListNode(cur.next.label);
                map.put(cur.next, copyNext);
            }
            //create the random node
            if(cur.random != null && !map.containsKey(cur.random)){
                RandomListNode copyRandom = new RandomListNode(cur.random.label);
                map.put(cur.random, copyRandom);
            }
            // connect next&random pointer
            if(cur.next != null) {
                map.get(cur).next = map.get(cur.next);
            }
            if(cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return map.get(head);
    }
}
