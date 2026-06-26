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
    int num;
    int ans;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        num = 1;
        count = k;
        inorder(root);
        return ans;
    }
    private void inorder(TreeNode root){
        if(root == null || num>count){
            return;
        }
        inorder(root.left);
        if(num==count){
            ans =  root.val;
        }
        num++;
        inorder(root.right);
    }
}
