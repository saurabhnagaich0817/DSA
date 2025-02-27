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
    private boolean res=true;

    public boolean isBalanced(TreeNode root) {

     find(root);
     return res;
       


    }
    public int find(TreeNode root){
        if(root == null){
            return 0;
        }
        int l=find(root.left);
        int r=find(root.right);
        if(Math.abs(l-r)>1){
            res=false;
        }
        return Math.max(l,r)+1;
        
    }
}