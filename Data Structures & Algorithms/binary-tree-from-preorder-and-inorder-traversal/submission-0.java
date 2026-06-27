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
    int preIdx = 0;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return make(preorder,0,inorder.length-1);
    }
    private TreeNode make(int[] preorder,int left,int right){
        if(left>right)return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int index = map.get(root.val);
        root.left = make(preorder,left,index-1);
        root.right = make(preorder,index+1,right);
        return root;
    }
}
