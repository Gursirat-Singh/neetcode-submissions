/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return DFS(root,-101);
    }
    private int DFS(TreeNode root,int max){
        if(root == null)return 0;
        if(root.val>=max){
        max = Math.max(max,root.val);
            return 1 + DFS(root.left,max) + DFS(root.right,max);
        }
        else {
            return DFS(root.left,max) + DFS(root.right,max);
        }
    }
}
