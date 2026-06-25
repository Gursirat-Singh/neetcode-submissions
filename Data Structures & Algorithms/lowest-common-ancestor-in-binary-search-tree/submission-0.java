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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        findPath(root,p,list1);
        findPath(root,q,list2);
        int i = 0,j=0;
        int n = list1.size();
        int m = list2.size();
        TreeNode lca = null;
        while(i<n && j<m){
            if(list1.get(i).val==list2.get(j).val)lca = list1.get(i);
            else break;
            i++;
            j++;
        }
        return lca;
    }
    private void findPath(TreeNode root,TreeNode key,List<TreeNode> list){
        if(root==null)return;
        list.add(root);
        if(root.val<key.val){
            findPath(root.right,key,list);
        }else if(root.val>key.val){
            findPath(root.left,key,list);
        }else{
            return;
        }
    }
}
