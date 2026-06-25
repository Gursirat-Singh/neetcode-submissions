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
    TreeNode prev = new TreeNode(-1001);
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root==null)return true;
        if(!inorder(root.left))return false;
        if(root.val<=prev.val)return false;
        else prev = root;
        if(!inorder(root.right))return false;
        return true;
    }
}
