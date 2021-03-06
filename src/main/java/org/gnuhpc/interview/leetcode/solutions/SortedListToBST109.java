package org.gnuhpc.interview.leetcode.solutions;

import org.gnuhpc.interview.leetcode.utils.ListNode;
import org.gnuhpc.interview.leetcode.utils.TreeNode;

public class SortedListToBST109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildAVL(head, null);
    }

    public static TreeNode buildAVL(ListNode start, ListNode end) {
        if (end == start) {
            return null;
        }

        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode treeNode = new TreeNode(slow.val);

        treeNode.left = buildAVL(start, slow);
        treeNode.right = buildAVL(slow.next, end);

        return treeNode;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        return buildAVLHelper(head, 0, lengthOfList(head) - 1);
    }

    private TreeNode buildAVLHelper(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode left = buildAVLHelper(head, start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;

        root.right = buildAVLHelper(head, mid + 1, end);
        return root;
    }

    private int lengthOfList(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
