//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 👍 1663 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
// Method 1: recursion way
//class Solution {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null || k == 1) {
//            return head;
//        }
//        ListNode cur = head;
//        int count = 0;
//        while (cur != null && count < k) {
//            cur = cur.next;
//            count++;
//        }
//        if (count == k) {
//            cur = reverseKGroup(cur, k);
//            while (count > 0) {
//                ListNode temp = head.next;
//                head.next = cur;
//                cur = head;
//                head = temp;
//                count--;
//            }
//            head = cur;
//        }
//        return head;
//    }
//}

// Method 2: iteration way
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        dummy.next = head;
        int count = 0;

        while (cur != null) {
            count++;
            if (count % k == 0) {
                pre = reverse(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode cur = prev.next;
        ListNode next = cur.next;
        while (next != end) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
