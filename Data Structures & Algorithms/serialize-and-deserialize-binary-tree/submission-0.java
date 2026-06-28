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

public class Codec {
    int index;
    String arr[];
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        make(root,sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())return null;
        arr = data.split(",");
        index = 0;
        return create();
    }
    private void make(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        make(root.left,sb);
        make(root.right,sb);
    }
    private TreeNode create(){
        if(arr[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left = create();
        root.right = create();
        return root;
    }
}
